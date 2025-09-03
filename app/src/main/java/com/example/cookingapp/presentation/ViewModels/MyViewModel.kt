package com.example.cookingapp.presentation.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cookingapp.domain.StateHandeling.GetAllCategoryState
import com.example.cookingapp.domain.Usecase.GetAllCategoryUsecase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MyViewModel @Inject constructor(private val getAllCategoryUsecase: GetAllCategoryUsecase) : ViewModel() {
    private val _getAllCategoryState = MutableStateFlow(GetAllCategoryState())
    val getAllCategoryState = _getAllCategoryState.asStateFlow()

    fun getAllCategories(){
        viewModelScope.launch {
            getAllCategoryUsecase.invoke().collect {result->

            }
        }

    }
}