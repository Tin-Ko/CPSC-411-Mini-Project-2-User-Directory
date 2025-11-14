package com.example.mini_project_2_offline_fisrt_app_user_directory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.mini_project_2_offline_fisrt_app_user_directory.data.local.UserDatabase
import com.example.mini_project_2_offline_fisrt_app_user_directory.data.remote.RetrofitInstance
import com.example.mini_project_2_offline_fisrt_app_user_directory.repository.UserRepository
import com.example.mini_project_2_offline_fisrt_app_user_directory.ui.theme.MiniProject2OfflineFisrtAppUserDirectoryTheme
import com.example.mini_project_2_offline_fisrt_app_user_directory.ui.view.UserScreen
import com.example.mini_project_2_offline_fisrt_app_user_directory.ui.viewmodel.UserViewModel
import com.example.mini_project_2_offline_fisrt_app_user_directory.ui.viewmodel.UserViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val database = UserDatabase.getDatabase(this)
        val repository = UserRepository(database.userDao(), RetrofitInstance.api)
        val factory = UserViewModelFactory(repository)
        val viewModel: UserViewModel by viewModels { factory }
        
        setContent {
            MiniProject2OfflineFisrtAppUserDirectoryTheme {
                UserScreen(viewModel = viewModel)
            }
        }
    }
}