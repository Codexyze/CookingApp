package com.example.cookingapp.presentation.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cookingapp.domain.StateHandeling.GetAllCategoryState
import com.example.cookingapp.domain.StateHandeling.ResultState
import com.example.cookingapp.domain.Usecase.GetAllCategoryUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(private val getAllCategoryUsecase: GetAllCategoryUsecase) : ViewModel() {
    private val _getAllCategoryState = MutableStateFlow(GetAllCategoryState())
    val getAllCategoryState = _getAllCategoryState.asStateFlow()
    init {

        getAllCategories()
    }

    fun getAllCategories(){
        viewModelScope.launch {
            getAllCategoryUsecase.invoke().collect {result->
                when(result){
                    is ResultState.isLoading->{
                        _getAllCategoryState.value = GetAllCategoryState(
                            isLoading = true
                        )
                    }
                    is ResultState.Success->{
                        _getAllCategoryState.value = GetAllCategoryState(
                            isLoading = false,
                            data = result.data,
                        )

                    }
                    is ResultState.Error -> {
                        _getAllCategoryState.value = GetAllCategoryState(
                            isLoading = false,
                            error = result.message
                        )

                    }
                }

            }
        }

    }
}