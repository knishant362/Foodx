package com.example.foodx.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.foodx.models.FoodRecipe
import com.example.foodx.util.Constants.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
class RecipesEntity (
        val foodRecipe : FoodRecipe
) {
    @PrimaryKey(autoGenerate = false)
    var id : Int = 0

}