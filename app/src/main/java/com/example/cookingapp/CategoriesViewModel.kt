package com.example.cookingapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class CategoriesViewModel : ViewModel() {
    var categories by mutableStateOf(emptyList<Category>())
        private set

    var errorMessage by mutableStateOf("")
        private set

    // Function to fetch categories
    fun fetchCategories() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getCategories()
                categories = response.categories // Assuming 'categories' is a property in your Categories model
                errorMessage = ""  // Clear any previous error messages
            } catch (e: HttpException) {
                errorMessage = "HTTP error: ${e.code()}"
            } catch (e: IOException) {
                errorMessage = "Network error: ${e.message}"
            } catch (e: Exception) {
                errorMessage = "Unexpected error: ${e.message}"
            }
        }
    }
    fun getCategoryById(categoryId: String?): Category? {
        return categories.find { it.idCategory == categoryId }
    }
}
