package di

import config.ConfigRepository
import file.FileDownloadHandler
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import org.koin.dsl.module
import start.StartViewModel
import url.ExternalUrlHandler


val clientModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json()
            }
        }
    }
    single { StartViewModel(get(), get(), get()) }
    single { ConfigRepository(get()) }
    single { ExternalUrlHandler() }
    single { FileDownloadHandler() }
}

