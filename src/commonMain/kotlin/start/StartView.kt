package start

import ProfilePicture
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import org.jetbrains.compose.resources.ExperimentalResourceApi
import ui.TintedImage
import ui.theme.AppTheme
import ui.theme.Spacing
import ui.theme.TextContent


@Composable
internal fun StartView() {
    val name = "Justin Salér"
    val emailAddress = "justin.saler.r@gmail.com"
    val contactMeItems = listOf(
        "images/github.png" to "@leptonquark",
        "images/linkedin.png" to "@justinsaler",
        "images/twitter.png" to "@leetkingen",
    )
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
                    ProfilePicture(name)
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            name,
                            style = MaterialTheme.typography.headlineMedium,
                            color = MaterialTheme.colorScheme.onSurface,
                        )
                        Text(
                            emailAddress,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.primary,
                        )
                    }
                }
                Row(horizontalArrangement = Arrangement.spacedBy(Spacing.S)) {
                    contactMeItems.forEach { (icon, profileName) -> ContactMeIcon(icon, profileName) }
                }
                DownloadResumeButton()
            }
        }
    }
}


@Composable
private fun DownloadResumeButton() {
    Button(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        onClick = {}
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(Spacing.XS)) {
            Icon(Icons.Filled.Download, contentDescription = null)
            Text(TextContent.DownloadResume)
        }
    }
}

@Composable
private fun ContactMeIcon(icon: String, profileName: String) {
    val contentColor = MaterialTheme.colorScheme.secondary
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Spacing.XXS),
    ) {
        TintedImage(icon, contentColor)
        Text(text = profileName, color = contentColor, style = MaterialTheme.typography.labelSmall)
    }
}
