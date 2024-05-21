package com.example.myapplication.repository

import com.example.myapplication.data.User

interface UsersRepository {

    suspend fun getAllUsers(): List<User>

    suspend fun insertUser(user: User)

}
