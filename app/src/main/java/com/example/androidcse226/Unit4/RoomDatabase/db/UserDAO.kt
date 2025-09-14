package com.example.androidcse226.Unit4.RoomDatabase.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    // CREATE
    @Insert
    suspend fun insertUser(user: UsersEntity)

    // READ
    @Query("SELECT * FROM users ORDER BY id ASC")
    fun getAllUsers(): LiveData<List<UsersEntity>>

    // UPDATE
    @Update
    suspend fun updateUser(user: UsersEntity)

    // DELETE
    @Delete
    suspend fun deleteUser(user: UsersEntity)
}


