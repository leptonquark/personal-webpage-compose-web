package start

import config.Config
import config.ConfigRepository
import di.Singleton
import file.FileDownloadHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.mapLatest
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

@OptIn(ExperimentalCoroutinesApi::class)
@Singleton
class StartViewModel @Inject constructor(
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
        contactMeItems = contactMe.mapNotNull { url -> getContactMeItemOrNull(url) }.toSet(),
        )

    private fun getContactMeItemOrNull(url: String) : ContactMeItem? {
        val patterns = mapOf(
            "LinkedIn" to Regex("https://www\\.linkedin\\.com/in/([^/]+)"),
            "GitHub" to Regex("https://github\\.com/([^/]+)"),
            "Twitter" to Regex("https://twitter\\.com/([^/]+)")
        )

        val (platform, userName) = patterns.entries.firstNotNullOfOrNull { (platform, pattern) ->
            pattern.find(url)?.run { platform to groupValues[1] }
        } ?: (null to null)

        return userName?.let {
            when (platform) {
                "GitHub" -> ContactMeItem.GitHub(it)
                "LinkedIn" -> ContactMeItem.LinkedIn(it)
                "Twitter" -> ContactMeItem.Twitter(it)
                else -> null
            }
        }
    }
}


