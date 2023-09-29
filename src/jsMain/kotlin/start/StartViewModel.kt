package start

import config.ConfigRepository
import di.Singleton
import file.FileDownloadHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import me.tatarka.inject.annotations.Inject
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

@Singleton
class StartViewModel @Inject constructor(
    private val configRepository: ConfigRepository,
    private val externalUrlHandler: ExternalUrlHandler,
    private val fileDownloadHandler: FileDownloadHandler,
) {
    private val viewModelScope = CoroutineScope(Dispatchers.Main)

    val state = flow {
        emit(
            StartState(
                name = configRepository.name,
                emailAddress = configRepository.email,
                contactMeItems = configRepository.contactMeItems,
            )
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = StartState()
    )

    fun sendIntent(intent: StartIntent) = when(intent){
        is StartIntent.ContactMeItemClick -> externalUrlHandler.navigateTo(intent.item.url)
        StartIntent.DownloadResumeClick -> fileDownloadHandler.download(RESUME_URL)
    }
}
