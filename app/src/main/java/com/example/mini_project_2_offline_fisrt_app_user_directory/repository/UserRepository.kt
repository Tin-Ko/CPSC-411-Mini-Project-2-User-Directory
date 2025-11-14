package com.example.mini_project_2_offline_fisrt_app_user_directory.repository

import android.util.Log
import com.example.mini_project_2_offline_fisrt_app_user_directory.data.local.UserDao
import com.example.mini_project_2_offline_fisrt_app_user_directory.data.remote.ApiService

class UserRepository(private val userDao: UserDao, private val apiService: ApiService) {

    val users = userDao.getUsers()

    suspend fun refreshUsers() {
        try {
            val usersFromApi = apiService.getUsers()
            userDao.insertUsers(usersFromApi)
        } catch (e: Exception) {
            Log.e("UserRepository", "Error refreshing users", e)
        }
    }
    fun searchUsers(query: String) = userDao.searchUsers("%" + query + "%")
}