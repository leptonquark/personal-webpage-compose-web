package url

import kotlinx.browser.window

class ExternalUrlHandler {
    fun navigateTo(url: String) {
        window.location.href = url
    }
}
