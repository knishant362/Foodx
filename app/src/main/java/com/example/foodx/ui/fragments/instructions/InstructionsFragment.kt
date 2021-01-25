package com.example.foodx.ui.fragments.instructions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import com.example.foodx.R
import com.example.foodx.models.Result
import com.example.foodx.util.Constants.Companion.RECIPE_RESULT_KEY
import kotlinx.android.synthetic.main.fragment_instructions.view.*


class InstructionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val mView =  inflater.inflate(R.layout.fragment_instructions, container, false)

        val args = arguments
        val myBundle: Result? = args?.getParcelable(RECIPE_RESULT_KEY)

        mView.instruction_webView.webViewClient = object : WebViewClient(){}
        val websiteUrl : String = myBundle!!.sourceUrl
        mView.instruction_webView.loadUrl(websiteUrl)

        return mView
    }

}