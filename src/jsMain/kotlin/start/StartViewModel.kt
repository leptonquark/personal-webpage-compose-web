package start

import di.Singleton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import me.tatarka.inject.annotations.Inject

data object StartState

data object StartIntent



@Singleton
class StartViewModel @Inject constructor() {
    private val viewModelScope = CoroutineScope(Dispatchers.Main)

    val state = flow {
        emit(StartState)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = StartState
    )

    fun sendIntent(intent: StartIntent) = Unit
}
