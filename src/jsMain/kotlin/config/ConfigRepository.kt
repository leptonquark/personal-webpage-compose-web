package config

import me.tatarka.inject.annotations.Inject
import start.contactme.ContactMeItem

class ConfigRepository @Inject constructor() {

    val name: String = "Justin Salér"
    val email: String = "justin.saler.r@gmail.com"
    val contactMeItems = setOf(
        ContactMeItem.GitHub("leptonquark"),
        ContactMeItem.LinkedIn("justinsaler"),
        ContactMeItem.Twitter("leetkingen"),
    )
}