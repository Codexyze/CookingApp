package com.example.cookingapp.domain.StateHandeling

import com.example.cookingapp.data.Remote.Categories
import com.example.cookingapp.data.Remote.Category

sealed class ResultState<out T>(){
    object isLoading: ResultState<Nothing>()
    data class Success<T>(val data:T): ResultState<T>()
    data class Error<T>(val message: String): ResultState<T>()
}

data class GetAllCategoryState(
    val isLoading: Boolean = false,
    val data: Categories? = null,
    val error: String = ""
)