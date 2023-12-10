package app

import app.di.ClientModule
import app.start.StartScreen
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

fun main() {
    startKoin {
        printLogger()
        modules(ClientModule().module)
    }
    StartScreen().initialize()
}
