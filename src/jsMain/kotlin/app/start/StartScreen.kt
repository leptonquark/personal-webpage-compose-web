package app.start

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import kotlinx.browser.document
import org.jetbrains.skiko.wasm.onWasmReady
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.w3c.dom.Document

private const val LOADER_ID = "loader"

@OptIn(ExperimentalComposeUiApi::class)
class StartScreen : KoinComponent {

    private val viewModel: StartViewModel by inject()

    private val Document.loader get() = getElementById(LOADER_ID)

    fun initialize() {
        onWasmReady {
            document.loader?.remove()
            CanvasBasedWindow("Justin Salér") {
                val state by viewModel.state.collectAsState()
                StartView(
                    name = state.name,
                    emailAddress = state.emailAddress,
                    role = state.role,
                    contactMeItems = state.contactMeItems,
                    onEmailClick = { sendIntent(StartIntent.EmailClick) },
                    onContactMeItemClick = { sendIntent(StartIntent.ContactMeItemClick(it)) },
                    onDownloadResumeClick = { sendIntent(StartIntent.DownloadResumeClick) },
                )
            }
        }
    }

    private fun sendIntent(intent: StartIntent) = viewModel.sendIntent(intent)
}
