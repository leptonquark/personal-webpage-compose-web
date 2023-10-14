package ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import ui.theme.size.withDensity

private const val MOBILE_DENSITY_MULTIPLIER = 3

expect val userAgent: String

private val isMobile: Boolean
    get()  {
        val mobileKeywords = setOf("Mobile", "Android", "iPhone", "iPad", "iPod", "Windows Phone")
        return mobileKeywords.any { keyword -> userAgent.contains(keyword) }
    }

@Composable
internal fun adjustMobileDensity(content: @Composable () -> Unit) {
    val density = if (isMobile) {
        MOBILE_DENSITY_MULTIPLIER * LocalDensity.current.density
    } else {
        LocalDensity.current.density
    }
    withDensity(density, content)
}
