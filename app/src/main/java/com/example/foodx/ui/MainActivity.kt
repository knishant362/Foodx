package com.example.foodx.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.foodx.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

//b44d1bfbaa8647d0a422d4a4479ef528
//https://api.spoonacular.com/recipes/complexSearch?number=1&apiKey=b44d1bfbaa8647d0a422d4a4479ef528
//https://api.spoonacular.com/recipes/complexSearch?number=1&apiKey=b44d1bfbaa8647d0a422d4a4479ef528&type=finger%20food&diet=vegan&addRecipeInformation=true&ingridents=true

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                    R.id.recipesFragment,
                    R.id.favoriteRecipesFragment,
                    R.id.foodJokeFragment
            )
        )

        bottomNavigationView.setupWithNavController(navController)
        setupActionBarWithNavController(navController, appBarConfiguration)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}