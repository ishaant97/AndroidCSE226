package com.example.androidcse226.Unit4.RoomDatabase.db

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: UserRepository
    val allUsers: LiveData<List<UsersEntity>>

    init {
        val userDao = AppDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        allUsers = repository.allUsers
    }

    fun insert(user: UsersEntity) = viewModelScope.launch {
        repository.insert(user)
    }

    fun update(user: UsersEntity) = viewModelScope.launch {
        repository.update(user)
    }

    fun delete(user: UsersEntity) = viewModelScope.launch {
        repository.delete(user)
    }
}
