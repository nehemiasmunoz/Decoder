package com.marvic.decoder.data.repository

import com.marvic.decoder.data.database.room.UserDao
import com.marvic.decoder.models.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class UserDaoImpl @Inject constructor(private val userDao: UserDao) {
    suspend fun addUser(user: User) = userDao.insertUser(user)
    suspend fun updateUser(user: User) = userDao.updateUser(user)
    suspend fun deleteUser(user: User) = userDao.deleteUser(user)
    fun getAllUsers(): Flow<List<User>> =
        userDao.getAllUsers().flowOn(Dispatchers.IO).conflate()
}