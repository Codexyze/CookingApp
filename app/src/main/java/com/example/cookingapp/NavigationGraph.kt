package com.example.cookingapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationGraph(navController: NavHostController, viewModel: CategoriesViewModel) {
    NavHost(navController = navController, startDestination = "categoryScreen") {
        composable("categoryScreen") {
            CategoryScreen(viewModel = viewModel, navController = navController)
        }
        composable("detailedScreen/{categoryId}") { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getString("categoryId")
            DetailedScreen(categoryId = categoryId, viewModel = viewModel) // Pass viewModel here
        }
    }
}
