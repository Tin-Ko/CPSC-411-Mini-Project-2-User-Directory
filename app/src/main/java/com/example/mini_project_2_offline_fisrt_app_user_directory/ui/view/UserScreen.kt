package com.example.mini_project_2_offline_fisrt_app_user_directory.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mini_project_2_offline_fisrt_app_user_directory.data.model.User
import com.example.mini_project_2_offline_fisrt_app_user_directory.ui.viewmodel.UserViewModel

@Composable
fun UserListItem(user: User) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "ID: ${user.id}")
            Text(text = "Name: ${user.name}")
            Text(text = "Email: ${user.email}")
            Text(text = "Phone: ${user.phone}")
        }
    }
}

@Composable
fun UserList(users: List<User>) {
    LazyColumn {
        items(users) {
            UserListItem(user = it)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(query: String, onQueryChange: (String) -> Unit) {
    TextField(
        value = query,
        onValueChange = onQueryChange,
        label = { Text("Search by name or email") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    )
}

@Composable
fun UserScreen(viewModel: UserViewModel) {
    val users by viewModel.users.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()

    Column {
        SearchBar(query = searchQuery, onQueryChange = viewModel::onSearchQueryChange)
        UserList(users = users)
    }
}