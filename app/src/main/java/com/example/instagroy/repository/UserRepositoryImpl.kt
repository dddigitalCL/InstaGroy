package com.example.instagroy.repository

import com.example.instagroy.data.local.LocalUserDataSource
import com.example.instagroy.data.model.UserList

class UserRepositoryImpl(private val dataSource: LocalUserDataSource) :UserRepository {

    override suspend fun getUsers(): UserList {
       return dataSource.getUsers()
    }
}