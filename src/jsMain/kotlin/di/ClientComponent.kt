package di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides
import start.StartScreen

@Singleton
@Component
abstract class ClientComponent {
    abstract val startScreen: StartScreen

    @Provides
    @Singleton
    fun httpClient(): HttpClient = HttpClient {
        install(ContentNegotiation) {
            json()
        }
    }
}
