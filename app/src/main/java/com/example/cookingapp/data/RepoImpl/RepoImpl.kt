package com.example.cookingapp.data.RepoImpl

import com.example.cookingapp.data.ApiService.ApiService
import com.example.cookingapp.data.Remote.Categories
import com.example.cookingapp.domain.Repository.Repository
import com.example.cookingapp.domain.StateHandeling.ResultState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RepoImpl @Inject constructor(private val apiService: ApiService)  : Repository {
    override suspend fun getAllCategory(): Flow<ResultState<Categories>> = flow{
        try {
            emit(ResultState.isLoading)
            val data = apiService.getAllCategories()
            emit(ResultState.Success(data))


        }catch (e: Exception){
            emit(ResultState.Error("$e"))

        }
    }
}