package com.marvic.decoder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.marvic.decoder.navigation.NavManager
import com.marvic.decoder.ui.theme.DecoderTheme
import com.marvic.decoder.viewModels.user.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val userViewModel: UserViewModel by viewModels()
        setContent {
            DecoderTheme {
                NavManager(userViewModel)
            }
        }
    }
}