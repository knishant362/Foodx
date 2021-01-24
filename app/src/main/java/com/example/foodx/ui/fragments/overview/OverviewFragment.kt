package com.example.foodx.ui.fragments.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import coil.load
import com.example.foodx.R
import com.example.foodx.models.Result
import com.example.foodx.util.Constants.Companion.RECIPE_RESULT_KEY
import kotlinx.android.synthetic.main.fragment_overview.view.*
import org.jsoup.Jsoup


class OverviewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val mView = inflater.inflate(R.layout.fragment_overview, container, false)

        val args = arguments
        val myBundle : Result? = args?.getParcelable(RECIPE_RESULT_KEY)

        mView.img_main.load(myBundle?.image)
        mView.txt_title.text = myBundle?.title
        mView.txt_likes.text = myBundle?.aggregateLikes.toString()
        mView.txt_time.text = myBundle?.readyInMinutes.toString()
        
        myBundle?.summary.let {
            val summary = Jsoup.parse(it).text()
            mView.txt_summary.text = summary
        }

        if (myBundle?.vegetarian == true) {
            mView.img_vegetarian.setColorFilter(ContextCompat.getColor(requireContext(), R.color.green))
            mView.txt_vegetarian.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
        }

        if (myBundle?.vegan == true) {
            mView.img_vegan.setColorFilter(ContextCompat.getColor(requireContext(), R.color.green))
            mView.txt_vegan.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
        }

        if (myBundle?.glutenFree == true) {
            mView.img_gluten_free.setColorFilter(ContextCompat.getColor(requireContext(), R.color.green))
            mView.txt_gluten_free.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
        }

        if (myBundle?.dairyFree == true) {
            mView.img_dairy_free.setColorFilter(ContextCompat.getColor(requireContext(), R.color.green))
            mView.txt_dairy_free.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
        }

        if (myBundle?.veryHealthy == true) {
            mView.img_healthy.setColorFilter(ContextCompat.getColor(requireContext(), R.color.green))
            mView.txt_healthy.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
        }

        if (myBundle?.cheap == true) {
            mView.img_cheap.setColorFilter(ContextCompat.getColor(requireContext(), R.color.green))
            mView.txt_cheap.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
        }


        return mView
    }

}