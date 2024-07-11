package com.marvic.decoder.viewModels.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marvic.decoder.data.repository.UserDaoImpl
import com.marvic.decoder.models.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val userDao: UserDaoImpl) :
    ViewModel() {

    private val _user = MutableStateFlow<List<User>>(emptyList());
    val user = _user.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            userDao.getAllUsers().collect {
                if (it.isNullOrEmpty()) {
                    _user.value = emptyList()
                } else {
                    _user.value = it
                }
            }
        }
    }

    fun addUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userDao.addUser(user)
        }
    }

    fun updateUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userDao.updateUser(user)
        }
    }

    fun deleteUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userDao.deleteUser(user)
        }
    }
}