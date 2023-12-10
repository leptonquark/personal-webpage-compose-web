package config

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.Serializable

@Serializable
data class Config(
    val name: String,
    val email: String,
    val contactMe: List<String>,
)

class ConfigRepository (private val client: HttpClient) {
    val config = flow { emit(client.get("config.json").body<Config>()) }
}
