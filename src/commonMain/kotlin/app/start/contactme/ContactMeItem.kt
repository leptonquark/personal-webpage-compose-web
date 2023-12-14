package app.start.contactme

sealed class ContactMeItem(open val profileName: String) {
    data class GitHub(override val profileName: String) : ContactMeItem(profileName)
    data class LinkedIn(override val profileName: String) : ContactMeItem(profileName)
    data class Twitter(override val profileName: String) : ContactMeItem(profileName)

    companion object{
        private const val LINKED_IN_REGEX = "https://www\\.linkedin\\.com/in/([^/]+)"
        private const val GITHUB_REGEX = "https://github\\.com/([^/]+)"
        private const val TWITTER_REGEX = "https://twitter\\.com/([^/]+)"

        fun fromUrl(url: String): ContactMeItem? {
            val patterns = mapOf(
                { name: String -> LinkedIn(name) } to Regex(LINKED_IN_REGEX),
                { name: String -> GitHub(name) } to Regex(GITHUB_REGEX),
                { name: String -> Twitter(name) } to Regex(TWITTER_REGEX),
            )
            return patterns.entries.firstNotNullOfOrNull { (platform, pattern) ->
                pattern.find(url)?.run { platform(groupValues[1]) }
            }
        }
    }
}

val ContactMeItem.url get() = when (this) {
    is ContactMeItem.GitHub -> "https://github.com/$profileName"
    is ContactMeItem.LinkedIn -> "https://www.linkedin.com/in/$profileName"
    is ContactMeItem.Twitter -> "https://twitter.com/$profileName"
}
