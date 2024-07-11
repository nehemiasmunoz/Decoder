package com.marvic.decoder.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.marvic.decoder.viewModels.user.UserViewModel

@Composable
fun CustomTextfield(
    value: String,
    label: String,
    isError: Boolean = false,
    keyboardType: KeyboardType,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        isError = isError,
        singleLine = true,
        label = { Text(text = label) },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        onValueChange = onValueChange
    )
}

@Composable
fun DrawerContent(userViewModel: UserViewModel = viewModel(), navController: NavController) {
    val users by userViewModel.user.collectAsState()
    val user = users[0]
    if (users.isEmpty()) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ElevatedButton(onClick = { navController.navigate("UserRegisterView") }) {
                Text(text = "Ingresar datos")
            }
        }
    } else {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .background(color = Color.White)
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Column {
                Text(text = "Nombre usuario")
                Text(text = user.name)
                Text(text = "Edad usuario")
                Text(text = user.age.toString())

                if (user.diabetes) {
                    Text(text = "Tipo diabetes")
                    Text(text = user.diabetesType.name)
                }
                if (user.hypertension) {
                    Text(text = "Tiene hipertension")
                    Text(text = user.hypertensionType.name)

                }
            }
        }
    }
}