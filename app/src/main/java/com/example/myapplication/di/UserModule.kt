package com.example.myapplication.di

import com.example.myapplication.data.UserDao
import com.example.myapplication.repository.UsersRepository
import com.example.myapplication.repository.UsersRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class UserModule {

    @Provides
    fun provideUsersRepository(userDao: UserDao): UsersRepository {
        return UsersRepositoryImpl(userDao)
    }

//    @Provides
//    fun provideUserDao

}
