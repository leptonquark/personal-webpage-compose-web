package start

import di.Singleton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import me.tatarka.inject.annotations.Inject

data class StartState(
    val name: String = "",
    val emailAddress: String = "",
    val contactMeItems: List<Pair<String, String>> = emptyList(),
)

data object StartIntent



@Singleton
class StartViewModel @Inject constructor() {
    private val viewModelScope = CoroutineScope(Dispatchers.Main)

    val state = flow {
        emit(StartState(
            name = "Justin Salér",
            emailAddress = "justin.saler.r@gmail.com",
            contactMeItems = listOf(
                "images/github.png" to "@leptonquark",
                "images/linkedin.png" to "@justinsaler",
                "images/twitter.png" to "@leetkingen",
            ),
        ))
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = StartState()
    )

    fun sendIntent(intent: StartIntent) = Unit
}
