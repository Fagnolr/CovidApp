package com.example.coviddata.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coviddata.presentation.covid_data.CovidDataScreen
import com.example.coviddata.presentation.ui.theme.CovidAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CovidAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    CovidDataScreen()
                }
            }
        }
    }
}
