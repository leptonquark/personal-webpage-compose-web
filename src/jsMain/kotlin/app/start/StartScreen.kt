package app.start

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import org.jetbrains.skiko.wasm.onWasmReady
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@OptIn(ExperimentalComposeUiApi::class)
class StartScreen: KoinComponent {

    private val viewModel : StartViewModel by inject()

    fun initialize() {
        onWasmReady {
            CanvasBasedWindow("CV") {
                val state by viewModel.state.collectAsState()
                StartView(
                    name = state.name,
                    emailAddress = state.emailAddress,
                    contactMeItems = state.contactMeItems,
                    onContactMeItemClick = { sendIntent(StartIntent.ContactMeItemClick(it)) },
                    onDownloadResumeClick = { sendIntent(StartIntent.DownloadResumeClick) },
                )
            }
        }
    }

    private fun sendIntent(intent: StartIntent) = viewModel.sendIntent(intent)
}
