package start

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import theme.AppTheme
import theme.IconSize
import theme.Spacing

@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun StartView() {
    AppTheme {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(Spacing.S),
                ) {
                Image(
                    modifier = Modifier.size(256.dp).clip(CircleShape),
                    painter = painterResource("images/profile.png"),
                    contentDescription = "Justin Salér",
                )
                Text(
                    "Justin Salér",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineMedium,
                )
                Row(horizontalArrangement = Arrangement.spacedBy(Spacing.M)){
                    ContactMeIcon("images/github.png")
                    ContactMeIcon("images/linkedin.png")
                    ContactMeIcon("images/twitter.png")
                }

            }
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun ContactMeIcon(icon: String) {
    Image(
        modifier = Modifier.size(IconSize.L),
        painter = painterResource(icon),
        contentDescription = null,
    )
}
