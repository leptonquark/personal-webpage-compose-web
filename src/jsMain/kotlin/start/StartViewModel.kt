package start

import config.Config
import config.ConfigRepository
import file.FileDownloadHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.stateIn
import start.contactme.ContactMeItem
import start.contactme.url
import url.ExternalUrlHandler

data class StartState(
    val name: String = "",
    val emailAddress: String = "",
    val contactMeItems: Set<ContactMeItem> = emptySet(),
)

sealed interface StartIntent {
    data class ContactMeItemClick(val item: ContactMeItem) : StartIntent
    data object DownloadResumeClick : StartIntent
}

private const val RESUME_URL = "/resume.pdf"

@OptIn(ExperimentalCoroutinesApi::class)
class StartViewModel (
    configRepository: ConfigRepository,
    private val externalUrlHandler: ExternalUrlHandler,
    private val fileDownloadHandler: FileDownloadHandler,
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
        is StartIntent.ContactMeItemClick -> externalUrlHandler.navigateTo(intent.item.url)
        StartIntent.DownloadResumeClick -> fileDownloadHandler.download(RESUME_URL)
    }

    private fun Config.getStartState() = StartState(
        name = name,
        emailAddress = email,
        contactMeItems = contactMe.mapNotNull { url -> ContactMeItem.fromUrl(url) }.toSet(),
    )

}


