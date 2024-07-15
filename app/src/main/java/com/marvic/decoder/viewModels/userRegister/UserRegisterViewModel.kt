package com.marvic.decoder.viewModels.userRegister

import androidx.lifecycle.ViewModel
import com.marvic.decoder.models.User
import com.marvic.decoder.models.enums.diabetes.DiabetesType
import com.marvic.decoder.models.enums.hypertension.HypertensionType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class FormError(
    val nameError: String? = null,
    val ageError: String? = null,
)

@HiltViewModel
class UserRegisterViewModel @Inject constructor() :
    ViewModel() {
    private val _userForm = MutableStateFlow(User())
    val userForm: StateFlow<User> = _userForm

    private val _formError = MutableStateFlow(FormError())
    val formError: StateFlow<FormError> = _formError

    fun updateName(name: String) {
        _userForm.value = _userForm.value.copy(name = name)
    }

    fun updateAge(age: Int) {
        _userForm.value = _userForm.value.copy(age = age)
        validateAge(age)
    }

    fun updateDiabetes(hasDiabetes: Boolean) {
        _userForm.value = _userForm.value.copy(diabetes = hasDiabetes)
    }

    fun updateHypertension(hasHypertension: Boolean) {
        _userForm.value = _userForm.value.copy(hypertension = hasHypertension)
    }

    fun updateDiabetesType(diabetesType: DiabetesType) {
        _userForm.value = _userForm.value.copy(diabetesType = diabetesType)
    }

    fun updateHypertensionType(hypertensionType: HypertensionType) {
        _userForm.value = _userForm.value.copy(hypertensionType = hypertensionType)
    }

    private fun validateAge(age: Int) {
        val ageError = if (age <= 0) {
            "La edad debe ser mayor a 0"
        } else null
        _formError.value = _formError.value.copy(ageError = ageError)
    }
}