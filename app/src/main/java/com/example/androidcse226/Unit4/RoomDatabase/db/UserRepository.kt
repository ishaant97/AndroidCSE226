package com.example.androidcse226.Unit4.RoomDatabase.db

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {

    val allUsers: LiveData<List<UsersEntity>> = userDao.getAllUsers()

    suspend fun insert(user: UsersEntity) {
        userDao.insertUser(user)
    }

    suspend fun update(user: UsersEntity) {
        userDao.updateUser(user)
    }

    suspend fun delete(user: UsersEntity) {
        userDao.deleteUser(user)
    }
}
