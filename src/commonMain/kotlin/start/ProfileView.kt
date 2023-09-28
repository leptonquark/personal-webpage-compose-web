package start

import ProfilePicture
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import ui.theme.Spacing
import ui.theme.TextContent

@Composable
internal fun ProfileView(
    name: String,
    emailAddress: String,
    contactMeItems: List<Pair<String, String>>,
) {
    Column(
        modifier = Modifier.width(IntrinsicSize.Min),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ProfilePicture(name)
        Spacer(modifier = Modifier.height(Spacing.XS))
        ProfileName(name)
        EmailAddress(emailAddress)
        Spacer(modifier = Modifier.height(Spacing.M))
        ContactMeView(contactMeItems)
        Spacer(modifier = Modifier.height(Spacing.M))
        DownloadResumeButton()
    }
}

@Composable
private fun EmailAddress(emailAddress: String) {
    Text(
        emailAddress,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.titleSmall,
        color = MaterialTheme.colorScheme.primary,
    )
}

@Composable
private fun ProfileName(name: String) {
    Text(
        name,
        style = MaterialTheme.typography.headlineMedium,
        color = MaterialTheme.colorScheme.onSurface,
    )
}

@Composable
private fun DownloadResumeButton() {
    Button(modifier = Modifier.fillMaxWidth(), shape = MaterialTheme.shapes.large, onClick = {}) {
        Row(horizontalArrangement = Arrangement.spacedBy(Spacing.XS)) {
            Icon(Icons.Filled.Download, contentDescription = null)
            Text(TextContent.DownloadResume)
        }
    }
}