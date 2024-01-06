package app.mail

import kotlinx.browser.window
import org.koin.core.annotation.Single

@Single
class MailHandler {
    fun openMailService(emailAddress: String) {
        window.location.href = "mailto:$emailAddress"
    }
}
