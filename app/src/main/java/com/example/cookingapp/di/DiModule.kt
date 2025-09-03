package com.example.cookingapp.di

import com.example.cookingapp.data.ApiService.ApiService
import com.example.cookingapp.data.RepoImpl.RepoImpl
import com.example.cookingapp.domain.Repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DiModule {

    @Singleton
    @Providesad
    fun RetrofitInstance(): ApiService{
        return Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiService::class.java)
    }

    @Provides
    fun repositoryObj(apiService: ApiService): Repository{
        return RepoImpl(apiService = apiService)
    }

}