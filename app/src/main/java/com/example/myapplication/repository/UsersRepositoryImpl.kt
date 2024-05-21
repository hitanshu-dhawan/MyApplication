package com.example.myapplication.repository

import com.example.myapplication.data.User
import com.example.myapplication.data.UserDao
import java.lang.IllegalArgumentException
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
    private val userDao: UserDao
) : UsersRepository {

    override suspend fun getAllUsers(): List<User> {
        return userDao.getAllUsers()
    }

    override suspend fun insertUser(user: User) {
        if (user.name.isNullOrEmpty())
            throw IllegalArgumentException("User's name should not be null")

        return userDao.insertUser(user)
    }

}