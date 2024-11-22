package com.example.cookingapp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun CategoryScreen(viewModel: CategoriesViewModel, navController: NavController, modifier: Modifier = Modifier) {
    LaunchedEffect(Unit) {
        viewModel.fetchCategories() // Fetch categories when the screen is launched
    }

    val categories = viewModel.categories
    val errorMessage = viewModel.errorMessage

    // Display categories or an error message
    when {
        categories.isNotEmpty() -> {
            LazyColumn(
                modifier = modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                items(categories.chunked(2)) { categoryPair -> // Group categories in pairs
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        categoryPair.forEach { category -> // Iterate through each category
                            CategoryItem(
                                category = category,
                                navController = navController,
                                modifier = Modifier
                                    .weight(1f)
                                    .height(200.dp) // Fixed height for consistency
                            )
                        }
                    }
                }
            }
        }
        errorMessage.isNotEmpty() -> {
            Text(text = errorMessage, modifier = modifier) // Display error message
        }
        else -> {
            Text(text = "No categories available.", modifier = modifier) // Display when no categories are available
        }
    }
}

