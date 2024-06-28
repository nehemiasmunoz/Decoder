package com.marvic.decoder.views.userRegister

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.marvic.decoder.R
import com.marvic.decoder.components.CustomTextfield
import com.marvic.decoder.models.enums.diabetes.DiabetesType
import com.marvic.decoder.models.enums.diabetes.getDiabetesTypeList
import com.marvic.decoder.models.enums.hypertension.HypertensionType
import com.marvic.decoder.models.enums.hypertension.getHypertensionTypeList
import com.marvic.decoder.viewmodels.userRegister.UserRegisterViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserRegisterView(userRegisterViewModel: UserRegisterViewModel) {
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(
                    text = stringResource(R.string.register_topbar_title),
                )
            },
        )
    }) {
        UserRegisterBody(it, userRegisterViewModel)
    }
}

@Composable
fun UserRegisterBody(paddingValues: PaddingValues, userRegisterViewModel: UserRegisterViewModel) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = paddingValues.calculateTopPadding(), horizontal = 16.dp)
            .verticalScroll(rememberScrollState()),
    ) {
        UserRegisterForm(userRegisterViewModel)
    }
}

@Composable
fun UserRegisterForm(userRegisterViewModel: UserRegisterViewModel) {
    val user by userRegisterViewModel.userForm.collectAsState()
    NameTextField(userRegisterViewModel)
    Spacer(modifier = Modifier.height(5.dp))
    AgeTextField(userRegisterViewModel)
    Spacer(modifier = Modifier.height(5.dp))
    AffectionsCheckboxes(userRegisterViewModel)
    Spacer(modifier = Modifier.height(5.dp))
    if (user.diabetes) {
        HypertensionTypeDropdownMenu(userRegisterViewModel)
        Spacer(modifier = Modifier.height(5.dp))
    }
    if (user.hypertension) {
        DiabetesTypeDropdownMenu(userRegisterViewModel)
    }
    Spacer(modifier = Modifier.height(5.dp))
    SaveButton()
}

@Composable
fun SaveButton() {
    ElevatedButton(modifier = Modifier.fillMaxWidth(), onClick = { /*Todo: send data to db*/ }) {
        Text(text = "Guardar")
    }
}

@Composable
fun AffectionsCheckboxes(userRegisterViewModel: UserRegisterViewModel) {
    val value by userRegisterViewModel.userForm.collectAsState()
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = stringResource(R.string.register_checkbox_section_title))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = value.diabetes,
                onCheckedChange = { userRegisterViewModel.updateDiabetes(it) })
            Text(text = "Diabetes")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = value.hypertension,
                onCheckedChange = { userRegisterViewModel.updateHypertension(it) })
            Text(text = "Hipertension")
        }
    }
}


@Composable
fun NameTextField(userRegisterViewModel: UserRegisterViewModel) {
    val value by userRegisterViewModel.userForm.collectAsState()
    CustomTextfield(
        value = value.name,
        label = stringResource(R.string.register_textfield_nombre_usuario),
        keyboardType = KeyboardType.Text
    )
    {
        userRegisterViewModel.updateName(it)
    }

}

@Composable
fun AgeTextField(userRegisterViewModel: UserRegisterViewModel) {
    val value by userRegisterViewModel.userForm.collectAsState()
    CustomTextfield(
        value = value.age.toString(),
        label = stringResource(R.string.register_textfield_edad_usuario),
        keyboardType = KeyboardType.Number
    ) {
        userRegisterViewModel.updateAge(it.toInt())
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HypertensionTypeDropdownMenu(
    userRegisterViewModel: UserRegisterViewModel
) {
    val options: List<HypertensionType> = getHypertensionTypeList()
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(options[0].type) }
    ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = { expanded = !expanded }) {
        OutlinedTextField(
            value = selectedOptionText,
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth(),
            readOnly = true,
            onValueChange = {},
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
        )
        ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false })
        {
            options.forEach {
                DropdownMenuItem(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = { Text(text = it.type) },
                    onClick = {
                        selectedOptionText = it.type
                        userRegisterViewModel.updateHypertensionType(it)
                        expanded = false
                    }
                )
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiabetesTypeDropdownMenu(
    userRegisterViewModel: UserRegisterViewModel
) {
    val options: List<DiabetesType> = getDiabetesTypeList()
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(options[0].type) }
    ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = { expanded = !expanded }) {
        OutlinedTextField(
            value = selectedOptionText,
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth(),
            readOnly = true,
            onValueChange = {},
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
        )
        ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false })
        {
            options.forEach {
                DropdownMenuItem(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = { Text(text = it.type) },
                    onClick = {
                        selectedOptionText = it.type
                        userRegisterViewModel.updateDiabetesType(it)
                        expanded = false
                    }
                )
            }
        }
    }

}




