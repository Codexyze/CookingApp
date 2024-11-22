package com.example.cookingapp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun DetailedScreen(categoryId: String?, viewModel: CategoriesViewModel) {
    // Fetch the category using the viewModel
    val category = remember { viewModel.getCategoryById(categoryId) }

    // Create a scrollable state
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState), // Make the column scrollable
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top // Align content to the top
    ) {
        category?.let {
            Text(text = it.strCategory, style = MaterialTheme.typography.headlineLarge, fontSize =25.sp )
            Spacer(modifier = Modifier.height(8.dp))
            AsyncImage(
                model = it.strCategoryThumb,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp), // Set a fixed height for the image
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = it.strCategoryDescription,
                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 18.sp) // Larger text size
            )
        } ?: run {
            Text(text = "Loading...")
        }
    }
}
