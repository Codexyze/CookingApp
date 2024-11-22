package com.example.cookingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {

            val navController: NavHostController = rememberNavController() // Use NavHostController
            val viewModel: CategoriesViewModel = viewModel() // Get instance of CategoriesViewModel

            // Set up the main content
            Surface(color = MaterialTheme.colorScheme.background) {
                NavigationGraph(navController = navController, viewModel = viewModel)
            }
        }
    }
}
