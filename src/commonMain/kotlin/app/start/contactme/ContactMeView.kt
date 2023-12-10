package app.start.contactme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import app.ui.TintedImage
import app.ui.theme.size.Spacing

@Composable
internal fun ContactMeView(contactMeItems: Set<ContactMeItem>, onContactMeItemClick: (ContactMeItem) -> Unit) {
    Row(horizontalArrangement = Arrangement.spacedBy(Spacing.S)) {
        contactMeItems.forEach { item ->
            ContactMeIcon(item.icon, item.profileName) {
                onContactMeItemClick(item)
            }
        }
    }
}

private val ContactMeItem.icon: String
    get() = when (this) {
        is ContactMeItem.GitHub -> "images/github.png"
        is ContactMeItem.LinkedIn -> "images/linkedin.png"
        is ContactMeItem.Twitter -> "images/twitter.png"
    }

@Composable
private fun ContactMeIcon(icon: String, profileName: String, onClick: () -> Unit) {
    val contentColor = MaterialTheme.colorScheme.secondary
    Column(
        modifier = Modifier.clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = rememberRipple(),
            onClick = onClick,
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Spacing.XXS),
    ) {
        TintedImage(icon, contentColor)
        Text(text = profileName, color = contentColor, style = MaterialTheme.typography.labelSmall)
    }
}
