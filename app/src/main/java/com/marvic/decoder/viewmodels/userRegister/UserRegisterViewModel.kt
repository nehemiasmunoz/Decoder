package com.marvic.decoder.viewmodels.userRegister

import androidx.lifecycle.ViewModel
import com.marvic.decoder.models.User
import com.marvic.decoder.models.enums.diabetes.DiabetesType
import com.marvic.decoder.models.enums.hypertension.HypertensionType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class UserRegisterViewModel @Inject constructor() : ViewModel() {
    private val _userForm = MutableStateFlow(User())
    val userForm: StateFlow<User> = _userForm

    fun updateName(name: String) {
        _userForm.value = _userForm.value.copy(name = name)
    }

    fun updateEmail(email: String) {
        _userForm.value = _userForm.value.copy(email = email)
    }

    fun updateAge(age: Int) {
        _userForm.value = _userForm.value.copy(age = age)
    }

    fun updateDiabetes(diabetes: Boolean) {
        _userForm.value = _userForm.value.copy(diabetes = diabetes)
    }

    fun updateHypertension(hypertension: Boolean) {
        _userForm.value = _userForm.value.copy(hypertension = hypertension)
    }

    fun updateDiabetesType(diabetesType: DiabetesType) {
        _userForm.value = _userForm.value.copy(diabetesType = diabetesType)
    }

    fun updateHypertensionType(hypertensionType: HypertensionType) {
        _userForm.value = _userForm.value.copy(hypertensionType = hypertensionType)
    }

    fun updatePreferences(preferences: String) {
        _userForm.value = _userForm.value.copy(preferences = preferences)
    }
}