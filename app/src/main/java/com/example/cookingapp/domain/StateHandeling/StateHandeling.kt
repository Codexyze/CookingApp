package com.example.cookingapp.domain.StateHandeling

sealed class ResultState<out T>(){
    object isLoading: ResultState<Nothing>()
    data class Success<T>(val data:T): ResultState<T>()
    data class Error<T>(val message: String): ResultState<T>()
}

