package app.ui.theme.size

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density

@Composable
internal fun withDensity(density: Float, content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalDensity provides LocalDensity.current.copy(density),
        content = content
    )
}

private fun Density.copy(density: Float) = Density(density, fontScale)
