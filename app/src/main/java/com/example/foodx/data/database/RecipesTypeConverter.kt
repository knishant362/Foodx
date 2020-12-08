package com.example.foodx.data.database

import androidx.room.TypeConverter
import com.example.foodx.models.FoodRecipe
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RecipesTypeConverter {

    var gson = Gson()

    @TypeConverter
    fun foodRecipeToString(foodRecipe: FoodRecipe) :String {
        return gson.toJson(foodRecipe)
    }

    fun stringToFoodRecipe(data : String) {
        val listType = object : TypeToken<FoodRecipe>() {}.type
        return gson.fromJson(data , listType)
    }


}