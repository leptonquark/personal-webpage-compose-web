package app.start

import ProfilePicture
import androidx.compose.foundation.clickable
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
import app.start.contactme.ContactMeItem
import app.start.contactme.ContactMeView
import app.ui.theme.size.Spacing
import app.ui.theme.TextContent

@Composable
internal fun ProfileView(
    name: String,
    emailAddress: String,
    role: String,
    contactMeItems: Set<ContactMeItem>,
    onEmailClick: () -> Unit,
    onContactMeItemClick: (ContactMeItem) -> Unit,
    onDownloadResumeClick: () -> Unit,
) {
    Column(
        modifier = Modifier.width(IntrinsicSize.Min),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ProfilePicture(name)
        Spacer(modifier = Modifier.height(Spacing.XS))
        Name(name)
        Role(role)
        EmailAddress(emailAddress, onEmailClick)
        Spacer(modifier = Modifier.height(Spacing.M))
        ContactMeView(contactMeItems, onContactMeItemClick)
        Spacer(modifier = Modifier.height(Spacing.M))
        DownloadResumeButton(onDownloadResumeClick)
    }
}

@Composable
private fun Name(name: String) {
    Text(
        name,
        style = MaterialTheme.typography.headlineMedium,
        color = MaterialTheme.colorScheme.onSurface,
    )
}

@Composable
private fun Role(role: String) {
    Text(
        role,
        style = MaterialTheme.typography.titleSmall,
        color = MaterialTheme.colorScheme.onSurface,
    )
}

@Composable
private fun EmailAddress(emailAddress: String, onEmailClick: () -> Unit) {
    Text(
        modifier = Modifier.clickable(onClick = onEmailClick),
        text = emailAddress,
        style = MaterialTheme.typography.titleSmall,
        color = MaterialTheme.colorScheme.primary,
    )
}

@Composable
private fun DownloadResumeButton(onClick: () -> Unit) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        onClick = onClick
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(Spacing.XS)) {
            Icon(Icons.Filled.Download, contentDescription = null)
            Text(TextContent.DOWNLOAD_RESUME)
        }
    }
}
