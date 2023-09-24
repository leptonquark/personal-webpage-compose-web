import di.ClientComponent
import di.create


fun main() {
    val component = ClientComponent::class.create()
    val startScreen = component.startScreen
    startScreen.initialize()
}
