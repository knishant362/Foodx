package com.example.foodx.ui.fragments.recipes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodx.MainViewModel
import com.example.foodx.R
import com.example.foodx.adapters.RecipesAdapter
import com.example.foodx.util.Constants.Companion.API_KEY
import com.example.foodx.util.NetworkResult
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_recipes.view.*
import kotlin.system.measureTimeMillis

@AndroidEntryPoint
class RecipesFragment : Fragment() {

    private lateinit var mView: View
    private lateinit var mMainViewModel : MainViewModel
    private val mAdapter by lazy { RecipesAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment``
        mView = inflater.inflate(R.layout.fragment_recipes, container, false)

        mMainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)


        setUpRecyclerView()
        requestApiData()

        mMainViewModel.recipesResponse.observe(viewLifecycleOwner){ response ->
            when(response){

                is NetworkResult.Success -> {
                    hideShimmerEffect()
                    response.data?.let {
                        mAdapter.setData(it)
                    }
                }

                is NetworkResult.Error -> {
                    hideShimmerEffect()
                    Toast.makeText(requireContext() , response.message.toString() , Toast.LENGTH_SHORT).show()
                }

                is NetworkResult.Loading -> {
                    showShimmerEffect()
                }

            }
        }

        return mView
    }

    private fun requestApiData(){
        mMainViewModel.getRecipes(applyQueries())
    }

    private fun applyQueries(): Map<String, String> {

        val queries : HashMap<String, String> = HashMap()

        queries["number"] = "50"
        queries["apiKey"] = API_KEY
        queries["type"] = "snack"
        queries["diet"] = "vegan"
        queries["addRecipeInformation"] = "true"
        queries["fillIngredients"] = "true"

        return queries
    }

    private fun setUpRecyclerView() {
        mView.recycler_view.adapter = mAdapter
        mView.recycler_view.layoutManager = LinearLayoutManager(requireContext())
    }


    private fun showShimmerEffect () {
        mView.recycler_view.showShimmer()
    }

    private fun hideShimmerEffect () {
        mView.recycler_view.hideShimmer()
    }



}