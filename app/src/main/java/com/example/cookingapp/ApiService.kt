package com.example.cookingapp
import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface ApiService {
    @GET("categories.php")  // Replace with your actual endpoint
   suspend  fun getCategories():Categories
}
object RetrofitInstance{
    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/") // Replace with your base URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}////www.themealdb.com/api/json/v1/1/categories.php