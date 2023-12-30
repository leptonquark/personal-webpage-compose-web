package app.start.contactme


data class ContactMeItem(val profileName: String, val contactMePage: ContactMePage) {
    companion object {
        fun fromUrl(url: String) = ContactMePage.entries.firstNotNullOfOrNull { contactMePage ->
            contactMePage
                .takeIf { page -> url.startsWith(page.baseUrl) }
                ?.let { page -> ContactMeItem(profileName = url.removePrefix(page.baseUrl), contactMePage = page) }
        }
    }
}

enum class ContactMePage(val baseUrl: String) {
    GitHub("https://github.com/"),
    LinkedIn("https://www.linkedin.com/in/"),
    X("https://x.com/"),
}

val ContactMeItem.url get() = contactMePage.baseUrl + profileName
