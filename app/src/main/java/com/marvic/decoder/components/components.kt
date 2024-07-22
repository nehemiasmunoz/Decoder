package com.marvic.decoder.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
fun DrawerContent(
    userViewModel: UserViewModel,
    navController: NavController
) {
    val users = userViewModel.user.collectAsState()
    val user = users.value.firstOrNull()

    if (user == null) {
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
                .padding(vertical = 30.dp, horizontal = 8.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Datos del usuario", fontSize = 25.sp)
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    label = { Text(text = "Nombre usuario") },
                    value = user.name,
                    enabled = false,
                    onValueChange = {})
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    enabled = false,
                    label = { Text(text = "Edad usuario") },
                    value = user.age.toString(),
                    onValueChange = {})

                if (user.diabetes) {
                    Spacer(modifier = Modifier.height(10.dp))
                    OutlinedTextField(
                        enabled = false,
                        label = { Text(text = "Diabetes tipo") },
                        value = user.diabetesType.type,
                        onValueChange = {})
                }
                if (user.hypertension) {
                    Spacer(modifier = Modifier.height(10.dp))
                    OutlinedTextField(
                        enabled = false,
                        label = { Text(text = "Hipertension tipo") },
                        value = user.hypertensionType.type,
                        onValueChange = {})
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(modifier = Modifier.padding(horizontal = 10.dp)) {
                    ElevatedButton(onClick = { navController.navigate("UserRegisterView") }) {
                        Text(text = "Actualizar datos")
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    ElevatedButton(
                        onClick = { userViewModel.deleteUser(user) }
                    ) {
                        Text(text = "Eliminar datos")
                    }
                }
            }
        }
    }
}