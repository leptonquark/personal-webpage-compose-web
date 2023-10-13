package ui.theme

import kotlinx.browser.window

actual val isMobile: Boolean
    get()  {
    val userAgent = window.navigator.userAgent
    val mobileKeywords = setOf("Mobile", "Android", "iPhone", "iPad", "iPod", "Windows Phone")

    return mobileKeywords.any { keyword -> userAgent.contains(keyword) }
}