package com.example.cookingapp.domain.Usecase

import com.example.cookingapp.data.Remote.Categories
import com.example.cookingapp.domain.Repository.Repository
import com.example.cookingapp.domain.StateHandeling.ResultState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllCategoryUsecase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke(): Flow<ResultState<Categories>>{
        return repository.getAllCategory()

    }
}