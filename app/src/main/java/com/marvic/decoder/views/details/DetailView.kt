package com.marvic.decoder.views.details

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailView(ingredientName: String, navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier,
                title = { Text(text = ingredientName) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "return")
                    }
                }
            )
        },
        content = { paddingValues -> DetailBody(paddingValues.calculateTopPadding()) },
    )
}

@Composable
fun DetailBody(paddingValues: Dp) {
    Column(modifier = Modifier.padding(vertical = paddingValues)) {
        Text(text = "Descripcion")
    }
}