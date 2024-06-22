package com.marvic.decoder.viewmodels.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    //Textfield y stateflow
    private val _text = MutableStateFlow("")
    val text: StateFlow<String> = _text

    //validacion
    private val _isTextValid = MutableStateFlow(true)
    val isTextValid: StateFlow<Boolean> = _isTextValid

    //cambiar el contenido
    fun onTextChange(newText: String) {
        _text.value = newText;
    }

    // hacer busqueda
    fun searchIngredient() {
        val currentText = _text.value
        _isTextValid.value = currentText.isNotBlank()
        if (_isTextValid.value) {
            //make search
        }
    }


}