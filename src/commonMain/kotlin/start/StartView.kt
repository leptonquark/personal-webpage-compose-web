package start

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.style.TextAlign
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import theme.AppTheme
import theme.IconSize
import theme.ImageSize
import theme.Spacing


@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun StartView() {
    AppTheme {
        Box(
            modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.surface),
            contentAlignment = Alignment.Center,
        ) {
            Column(
                modifier = Modifier.width(IntrinsicSize.Min),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(Spacing.M),
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(Spacing.XS),
                ) {
                    Image(
                        modifier = Modifier.size(ImageSize.Profile).clip(CircleShape),
                        painter = painterResource("images/profile.png"),
                        contentDescription = "Justin Salér",
                    )
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            "Justin Salér",
                            style = MaterialTheme.typography.headlineMedium,
                            color = MaterialTheme.colorScheme.onSurface,
                        )
                        Text(
                            "justin.saler.r@gmail.com",
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.primary,
                        )
                    }
                }
                Row(horizontalArrangement = Arrangement.spacedBy(Spacing.S)) {
                    ContactMeIcon("images/github.png", "@leptonquark")
                    ContactMeIcon("images/linkedin.png", "@justinsaler")
                    ContactMeIcon("images/twitter.png", "@leetkingen")
                }
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.large,
                    onClick = {}
                ){
                    Row(horizontalArrangement = Arrangement.spacedBy(Spacing.XS)){
                        Icon(
                            Icons.Filled.Download,
                            contentDescription = null,
                        )
                        Text("Download Resumé")
                    }

                }

            }
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun ContactMeIcon(icon: String, profileName: String) {
    val contentColor = MaterialTheme.colorScheme.secondary
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Spacing.XXS),
    ) {
        Image(
            modifier = Modifier.size(IconSize.L),
            painter = painterResource(icon),
            contentDescription = null,
            colorFilter = ColorFilter.tint(contentColor, BlendMode.SrcAtop),
        )
        Text(text = profileName, color = contentColor, style = MaterialTheme.typography.labelSmall)
    }
}
