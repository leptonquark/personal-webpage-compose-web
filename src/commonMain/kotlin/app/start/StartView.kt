package app.start

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import app.start.contactme.ContactMeItem
import app.ui.theme.AppTheme

@Composable
internal fun StartView(
    name: String,
    emailAddress: String,
    contactMeItems: Set<ContactMeItem>,
    onEmailClick: () -> Unit,
    onContactMeItemClick: (ContactMeItem) -> Unit,
    onDownloadResumeClick: () -> Unit,
) {
    AppTheme {
        Box(
            modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.surface),
            contentAlignment = Alignment.Center,
        ) {
            ProfileView(
                name = name,
                emailAddress = emailAddress,
                contactMeItems = contactMeItems,
                onEmailClick = onEmailClick,
                onContactMeItemClick = onContactMeItemClick,
                onDownloadResumeClick = onDownloadResumeClick,
            )
        }
    }
}
