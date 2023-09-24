package di

import me.tatarka.inject.annotations.Component
import start.StartScreen

@Singleton
@Component
abstract class ClientComponent {
    abstract val startScreen: StartScreen
}
