package start.contactme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import ui.TintedImage
import ui.theme.Spacing

@Composable
internal fun ContactMeView(contactMeItems: Set<ContactMeItem>) {
    Row(horizontalArrangement = Arrangement.spacedBy(Spacing.S)) {
        contactMeItems.forEach { ContactMeIcon(it.icon, it.profileName) }
    }
}

private val ContactMeItem.icon: String
    get() = when(this){
        is ContactMeItem.GitHub -> "images/github.png"
        is ContactMeItem.LinkedIn -> "images/linkedin.png"
        is ContactMeItem.Twitter -> "images/twitter.png"
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
