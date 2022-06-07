package ar.com.composehexagonalarchitecture.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ar.com.composehexagonalarchitecture.application.Application
import ar.com.composehexagonalarchitecture.domain.User
import ar.com.composehexagonalarchitecture.ui.components.Thumb
import ar.com.composehexagonalarchitecture.ui.theme.ComposeHexagonalArchitectureTheme
import ar.com.composehexagonalarchitecture.ui.viewmodel.UsersViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var application: Application

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        application.initialize()

        setContent {
            MyApp {
                UserListState()
            }
        }
    }

    //statefull
    @Composable
    fun UserListState(viewModel: UsersViewModel = viewModel()) {
        val users: List<User> by viewModel.users
            .collectAsState()

        val isUsersLoading: Boolean by viewModel.loading
            .collectAsState()

        Log.d("IsLoading", isUsersLoading.toString())

        if (isUsersLoading) UsersLoadingProgressIndicator() else UsersList(userList = users) { /*TODO*/ }
    }

    //stateless
    @Composable
    fun UsersList(
        userList: List<User>,
        onClick: (User) -> Unit,
    ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(4.dp),
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp)
            ) {
                items(userList) { user ->
                    UserItem(
                        user = user,
                        onClick = { onClick(user) }
                    )
                }
            }
    }

    @Composable
    fun UserItem(
        user: User,
        onClick: () -> Unit,
        modifier: Modifier = Modifier
    ) {
        Card(
            modifier = modifier.clickable { onClick() }
                .padding(end = 16.dp),
            elevation = 4.dp,
            border = BorderStroke(color = Color.White, width = 4.dp)
        ) {
            Column(horizontalAlignment = CenterHorizontally,) {
                Thumb(user = user)
                Spacer(modifier = Modifier.height(8.dp))
               // Title(user)
                Text(
                    text = user.fullName,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.h6,
                    color = Color.Black,
                    modifier = Modifier.padding(horizontal = 16.dp).align(CenterHorizontally),
                    fontStyle = FontStyle.Italic
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = user.email,
                    style = MaterialTheme.typography.body1,
                    color = Color.Black,
                    modifier = Modifier.padding(horizontal = 16.dp).align(CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(4.dp))
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

    }

    @Composable
    fun UsersLoadingProgressIndicator() {
        Column(
            horizontalAlignment = CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator()
        }
    }


    @Composable
    fun MainAppBar() {
        TopAppBar(
            title = { Text("App") },
            actions = {
                AppBarAction(
                    imageVector = Icons.Default.Search,
                    onClick = { /* TODO */ }
                )
                AppBarAction(
                    imageVector = Icons.Default.Share,
                    onClick = { /* TODO */ }
                )
            }
        )
    }


    @Composable
    private fun AppBarAction(
        imageVector: ImageVector,
        onClick: () -> Unit
    ) {
        IconButton(onClick = onClick) {
            Icon(
                imageVector = imageVector,
                contentDescription = null
            )
        }
    }

    @Composable
    fun MyApp(content: @Composable () -> Unit) {
        ComposeHexagonalArchitectureTheme {
            Surface(color = MaterialTheme.colors.background) {
                content()
            }
        }
    }
}
