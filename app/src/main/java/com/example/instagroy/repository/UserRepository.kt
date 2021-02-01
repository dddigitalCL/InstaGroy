package com.example.instagroy.repository

import com.example.instagroy.data.model.UserList

interface UserRepository {

    suspend fun getUsers(): UserList
}