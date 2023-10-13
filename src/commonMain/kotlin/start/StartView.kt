package start

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import start.contactme.ContactMeItem
import ui.theme.AppTheme
import ui.theme.isMobile


@Composable
internal fun StartView(
    name: String,
    emailAddress: String,
    contactMeItems: Set<ContactMeItem>,
    onContactMeItemClick: (ContactMeItem) -> Unit,
    onDownloadResumeClick: () -> Unit,
) {
    CompositionLocalProvider(
        LocalDensity provides Density(
            if(isMobile) 3 * LocalDensity.current.density else LocalDensity.current.density,
            LocalDensity.current.fontScale
        )
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
                    onContactMeItemClick = onContactMeItemClick,
                    onDownloadResumeClick = onDownloadResumeClick,
                )
            }
        }
    }
}
