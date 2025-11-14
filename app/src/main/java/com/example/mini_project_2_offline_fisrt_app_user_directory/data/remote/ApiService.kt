package com.example.mini_project_2_offline_fisrt_app_user_directory.data.remote

import com.example.mini_project_2_offline_fisrt_app_user_directory.data.model.User
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers(): List<User>
}