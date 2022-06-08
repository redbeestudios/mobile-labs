package ar.com.composehexagonalarchitecture.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.com.composehexagonalarchitecture.domain.User

@Preview
@Composable
fun UserItemPreview() {
    UserItem(
        user = User(
            fullName = "Roberto Gomez Bolaños",
            email = "test@test.com",
            photos = listOf("https://randomuser.me/api/portraits/men/10.jpg")
        ),
        onClick = { /*TODO*/ }
    )
}

@Composable
fun UserItem(
    user: User,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .clickable { onClick() }
            .padding(end = 16.dp),
        elevation = 4.dp,
        border = BorderStroke(color = Color.White, width = 4.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,) {
            Thumb(url = user.photos?.get(0)!!)
            Spacer(modifier = Modifier.height(8.dp))
            // Title(user)
            Text(
                text = user.fullName,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.h6,
                color = Color.Black,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .align(Alignment.CenterHorizontally),
                fontStyle = FontStyle.Italic
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = user.email!!,
                style = MaterialTheme.typography.body1,
                color = Color.Black,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
    Spacer(modifier = Modifier.height(16.dp))

}