package app.start

import app.start.contactme.ContactMeItem

data class StartState(
    val name: String = "",
    val emailAddress: String = "",
    val role: String = "",
    val contactMeItems: Set<ContactMeItem> = emptySet(),
)