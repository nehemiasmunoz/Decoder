package com.marvic.decoder.views.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.marvic.decoder.R
import com.marvic.decoder.viewmodels.home.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController, homeViewModel: HomeViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth(),
                title = { Text(text = "Home") },
                actions = {
                    IconButton(onClick = { /*TODO: open camera*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_photo_camera_24),
                            contentDescription = "camera icon"
                        )
                    }
                },
            )
        },
        content = { paddingValues ->
            _HomeBody(
                paddingValues.calculateTopPadding(),
                navController = navController,
                homeViewModel = homeViewModel
            )
        }
    )
}


@Composable
fun _HomeBody(topPadding: Dp, navController: NavController, homeViewModel: HomeViewModel) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(top = topPadding + 10.dp)
    ) {
        CustomSearchBar(homeViewModel)
        IngredientsList(navController)
    }
}

@Composable
fun IngredientsList(navController: NavController) {
    LazyColumn {
        items(3) { index ->
            IngredientItem(navController, index)

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IngredientItem(navController: NavController, index: Int) {
    Card(
        onClick = { navController.navigate("DetailView/${"Ingredient $index"}") },
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Ingredient $index")
            Icon(imageVector = Icons.Default.Check, contentDescription = "Good")
        }
    }
}

@Composable
fun CustomSearchBar(homeViewModel: HomeViewModel) {
    //observamos desde el viewmodel
    val text by homeViewModel.text.collectAsState()
    val isTextValid by homeViewModel.isTextValid.collectAsState()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = {
                homeViewModel.onTextChange(it)
            },
            isError = !isTextValid,
            label = { Text(text = "Ingrediente") },
            placeholder = { Text(text = "Ej: Sucralosa") }
        )
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.Search, contentDescription = "search input")
        }
    }
}
