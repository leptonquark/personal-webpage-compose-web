package ui.theme

expect val userAgent: String

val isMobile: Boolean
    get()  {
        val mobileKeywords = setOf("Mobile", "Android", "iPhone", "iPad", "iPod", "Windows Phone")
        return mobileKeywords.any { keyword -> userAgent.contains(keyword) }
    }