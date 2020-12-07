package com.example.foodx.data.network

import com.example.foodx.models.FoodRecipe
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface FoodRecipesApi {

    @GET("/recipes/complexSearch")
    suspend fun getRecipess(
        @QueryMap queries: Map<String,String>
    ) : retrofit2.Response<FoodRecipe>

}