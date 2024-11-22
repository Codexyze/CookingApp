package com.example.cookingapp


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.navigation.NavController

@Composable
fun CategoryItem(category: Category, navController: NavController, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clickable {
                navController.navigate("detailedScreen/${category.idCategory}")
            }
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = category.strCategory,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp),
                style = MaterialTheme.typography.bodyMedium
            )
            AsyncImage(
                model = category.strCategoryThumb,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop
            )
        }
    }
}
