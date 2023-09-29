package start.contactme

sealed class ContactMeItem(open val profileName: String) {
    data class GitHub(override val profileName: String) : ContactMeItem(profileName)
    data class LinkedIn(override val profileName: String) : ContactMeItem(profileName)
    data class Twitter(override val profileName: String) : ContactMeItem(profileName)
}

val ContactMeItem.url get() = when (this) {
    is ContactMeItem.GitHub -> "https://github.com/$profileName"
    is ContactMeItem.LinkedIn -> "https://www.linkedin.com/in/$profileName"
    is ContactMeItem.Twitter -> "https://twitter.com/$profileName"
}