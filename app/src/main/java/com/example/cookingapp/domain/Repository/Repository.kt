package com.example.cookingapp.domain.Repository

import com.example.cookingapp.data.Remote.Categories
import retrofit2.http.GET

interface Repository {

    @GET("categories.php")
    suspend fun getAllCategory(): Categories
}