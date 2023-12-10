package app.ui

import kotlinx.browser.window

actual val userAgent: String get() = window.navigator.userAgent
