package app.url

import kotlinx.browser.window
import org.koin.core.annotation.Single

@Single
class ExternalUrlHandler {
    fun navigateTo(url: String) {
        window.location.href = url
    }
}
