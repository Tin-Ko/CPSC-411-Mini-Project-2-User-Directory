package com.example.mini_project_2_offline_fisrt_app_user_directory.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mini_project_2_offline_fisrt_app_user_directory.data.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    fun getUsers(): Flow<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(users: List<User>)

    @Query("SELECT * FROM users WHERE name LIKE :searchQuery OR email LIKE :searchQuery")
    fun searchUsers(searchQuery: String): Flow<List<User>>
}