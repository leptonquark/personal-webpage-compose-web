package start

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ui.theme.AppTheme


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
            ProfileView(name, emailAddress, contactMeItems)
        }
    }
}
