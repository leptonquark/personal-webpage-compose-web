package start

import di.Singleton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import me.tatarka.inject.annotations.Inject
import start.contactme.ContactMeItem

data class StartState(
    val name: String = "",
    val emailAddress: String = "",
    val contactMeItems: Set<ContactMeItem> = emptySet(),
)

data object StartIntent



@Singleton
class StartViewModel @Inject constructor() {
    private val viewModelScope = CoroutineScope(Dispatchers.Main)

    val state = flow {
        emit(StartState(
            name = "Justin Salér",
            emailAddress = "justin.saler.r@gmail.com",
            contactMeItems = setOf(
                ContactMeItem.GitHub("leptonquark"),
                ContactMeItem.LinkedIn("justinsaler"),
                ContactMeItem.Twitter("leetkingen"),
            ),
        ))
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = StartState()
    )

    fun sendIntent(intent: StartIntent) = Unit
}
