package com.example.foodx.ui.fragments.ingredients

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodx.R
import com.example.foodx.adapters.IngredientsAdapter
import com.example.foodx.models.Result
import com.example.foodx.util.Constants.Companion.RECIPE_RESULT_KEY

class IngredientsFragment : Fragment() {

    private val mAdapter: IngredientsAdapter by lazy { IngredientsAdapter() }
    private lateinit var ing_recycler_view: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val mView = inflater.inflate(R.layout.fragment_ingredients, container, false)

        val args = arguments
        val myBundle: Result? = args?.getParcelable(RECIPE_RESULT_KEY)
        ing_recycler_view = mView.findViewById(R.id.ingredients_recyclerview)

        setupRecyclerView(mView)
        myBundle?.extendedIngredients?.let {
            mAdapter.setData(it)
        }

        return mView
    }

    private fun setupRecyclerView(mView: View?) {
        ing_recycler_view.adapter = mAdapter
        ing_recycler_view.layoutManager = LinearLayoutManager(requireContext())
    }

}