package ar.com.composehexagonalarchitecture.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import ar.com.composehexagonalarchitecture.R
import ar.com.composehexagonalarchitecture.domain.User


@Composable
fun Title(user: User) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.secondary)
            .padding(dimensionResource(R.dimen.padding_medium))
    ) {
        Text(
            text = user.fullName,
            style = MaterialTheme.typography.h6
        )
    }
}

@Composable
@Preview
fun PreviewTitle() {
    val fullName = "Miron Olsthroorn"
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.secondary)
            .padding(dimensionResource(R.dimen.padding_medium))
    ) {
        Text(
            text = fullName,
            style = MaterialTheme.typography.h6
        )
    }
}