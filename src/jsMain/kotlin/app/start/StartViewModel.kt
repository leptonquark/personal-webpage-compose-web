package app.start

import app.config.Config
import app.config.ConfigRepository
import app.file.FileDownloadHandler
import app.mail.MailHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.stateIn
import app.start.contactme.ContactMeItem
import app.start.contactme.url
import app.url.ExternalUrlHandler
import org.koin.core.annotation.Single

sealed interface StartIntent {
    data object EmailClick : StartIntent
    data class ContactMeItemClick(val item: ContactMeItem) : StartIntent
    data object DownloadResumeClick : StartIntent
}

private const val RESUME_URL = "/resume.pdf"

@Single
@OptIn(ExperimentalCoroutinesApi::class)
class StartViewModel (
    configRepository: ConfigRepository,
    private val externalUrlHandler: ExternalUrlHandler,
    private val fileDownloadHandler: FileDownloadHandler,
    private val mailHandler: MailHandler,
) {
    private val viewModelScope = CoroutineScope(Dispatchers.Main)

    val state = configRepository.config.mapLatest { config ->
        config.getStartState()
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = StartState()
    )

    fun sendIntent(intent: StartIntent) = when (intent) {
        StartIntent.EmailClick -> mailHandler.openMailService(state.value.emailAddress)
        is StartIntent.ContactMeItemClick -> externalUrlHandler.navigateTo(intent.item.url)
        StartIntent.DownloadResumeClick -> fileDownloadHandler.download(RESUME_URL)
    }

    private fun Config.getStartState() = StartState(
        name = name,
        emailAddress = email,
        role = role,
        contactMeItems = contactMe.mapNotNull { url -> ContactMeItem.fromUrl(url) }.toSet(),
    )

}


