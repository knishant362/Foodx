package com.example.foodx.data.database

import androidx.room.Database
import androidx.room.TypeConverters

@Database(
        entities = [RecipesEntity::class],
        version = 1,
        exportSchema = false
)
@TypeConverters(RecipesTypeConverter::class)
abstract class RecipesDatabase {

    abstract fun recipeDao() : RecipesDao

}