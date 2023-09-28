package start

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import di.Singleton
import me.tatarka.inject.annotations.Inject
import org.jetbrains.skiko.wasm.onWasmReady

@OptIn(ExperimentalComposeUiApi::class)
@Singleton
class StartScreen @Inject constructor(private val viewModel: StartViewModel) {

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
