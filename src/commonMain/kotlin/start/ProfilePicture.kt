import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import ui.theme.ImageSize

private const val PROFILE_PICTURE = "images/profile.png"

@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun ProfilePicture(name: String) {
    Image(
        modifier = Modifier.size(ImageSize.Profile).clip(CircleShape),
        painter = painterResource(PROFILE_PICTURE),
        contentDescription = name,
    )
}
