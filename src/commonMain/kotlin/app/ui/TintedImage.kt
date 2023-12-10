package app.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import app.ui.theme.size.IconSize

@OptIn(ExperimentalResourceApi::class)
@Composable
fun TintedImage(icon: String, tint: Color) {
    Image(
        modifier = Modifier.size(IconSize.L),
        painter = painterResource(icon),
        contentDescription = null,
        colorFilter = ColorFilter.tint(tint, BlendMode.SrcAtop),
    )
}
