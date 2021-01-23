package com.example.foodx.data

import com.example.foodx.models.FoodRecipe
import com.example.foodx.data.network.FoodRecipesApi
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
        private val foodRecipesApi: FoodRecipesApi
) {

    suspend fun getRecipe(queries : Map<String, String>): Response<FoodRecipe>{
        return foodRecipesApi.getRecipess(queries)
    }
    
    suspend fun searchRecipes(searchQuery: Map<String, String>): Response<FoodRecipe> {
        return foodRecipesApi.searchRecipes(searchQuery)
    }
}