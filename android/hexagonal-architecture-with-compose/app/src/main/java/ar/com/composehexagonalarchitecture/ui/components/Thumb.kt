package ar.com.composehexagonalarchitecture.ui.components


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ar.com.composehexagonalarchitecture.R
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun Thumb(
    modifier: Modifier = Modifier,
    url: String,
    size: Dp = 60.dp,
    contentDescription: String = "",
    placeholder: Painter? = null
) {
    Box(
        modifier = modifier
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(url)
                .crossfade(true)
                .build(),
            placeholder = placeholder,
            contentDescription = contentDescription,
            modifier = Modifier
                .clip(CircleShape)
                .width(size)
                .height(size),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewThumb() {
    Thumb(url = "https://randomuser.me/api/portraits/men/10.jpg", placeholder = painterResource(id = R.drawable.ic_launcher_background))
}