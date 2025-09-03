package com.example.cookingapp.data.ApiService

import com.example.cookingapp.data.Remote.Categories
import retrofit2.http.GET

interface ApiService {

    @GET("categories.php")
    suspend fun getAllCategories(): Categories
}