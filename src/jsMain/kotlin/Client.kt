import di.clientModule
import org.koin.core.context.startKoin
import start.StartScreen


fun main() {
    startKoin { modules(clientModule) }
    StartScreen().initialize()
}
