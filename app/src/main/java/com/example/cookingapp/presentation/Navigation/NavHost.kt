package com.example.cookingapp.presentation.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.cookingapp.presentation.Screens.DetailedScreen
import com.example.cookingapp.presentation.Screens.GetAllCategoryScreen

@Composable
fun MainApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = GETALLCATEGORYSCREEN){
        composable<GETALLCATEGORYSCREEN> {
            GetAllCategoryScreen(navController = navController)
        }
        composable<DETAILEDSCREEN> {backstackEntry->
            val data: DETAILEDSCREEN = backstackEntry.toRoute()
            DetailedScreen(image = data.image , strCategoryDescription = data.strCategoryDescription)

        }

    }
}