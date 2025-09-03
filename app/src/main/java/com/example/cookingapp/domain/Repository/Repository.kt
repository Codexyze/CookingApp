package com.example.cookingapp.domain.Repository

import com.example.cookingapp.data.Remote.Categories
import com.example.cookingapp.domain.StateHandeling.ResultState
import kotlinx.coroutines.flow.Flow


interface Repository {

    suspend fun getAllCategory(): Flow<ResultState<Categories>>
}