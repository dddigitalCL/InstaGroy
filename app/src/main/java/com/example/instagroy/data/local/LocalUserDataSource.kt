package com.example.instagroy.data.local

import com.example.instagroy.data.model.UserEntity
import com.example.instagroy.data.model.UserList
import com.example.instagroy.data.model.toUserList

class LocalUserDataSource(private val userDao: UserDao) {

    suspend fun getUsers():UserList{
        return userDao.getAllUsers().toUserList()
    }

    suspend fun saveUser(user: UserEntity){
        userDao.saveUser(user)
    }
}