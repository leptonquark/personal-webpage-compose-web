package app.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan("app")
class ClientModule {
    @Single
    fun httpClient() = HttpClient {
        install(ContentNegotiation) {
            json()
        }
    }
}

