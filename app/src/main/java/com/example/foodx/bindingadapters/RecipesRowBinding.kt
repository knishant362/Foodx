package com.example.foodx.bindingadapters

import android.media.Image
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import coil.load
import com.example.foodx.R

class RecipesRowBinding {

    companion object {

        @BindingAdapter("loadImage")
        @JvmStatic
        fun loadImage (imageView : ImageView , url : String) {
            imageView.load(url) {
                crossfade(600)
            }
        }

        @BindingAdapter("setNoOfLikes")
        @JvmStatic
        fun setNoOfLikes ( textView : TextView , likes : Int) {
           textView.text = likes.toString()
        }

        @BindingAdapter("setCookTime")
        @JvmStatic
        fun setCookTime ( textView: TextView , time : Int) {
            textView.text = time.toString()
        }

        @BindingAdapter("checkVegan")
        @JvmStatic
        fun checkVegan ( view: View , vegan : Boolean) {
            if(vegan) {
                when(view) {
                    is TextView -> {
                        view.setTextColor(
                                ContextCompat.getColor(
                                        view.context,
                                        R.color.green
                                )
                        )
                    }
                    is ImageView -> {
                        view.setColorFilter(
                                ContextCompat.getColor(
                                        view.context,
                                        R.color.green
                                )
                        )
                    }
                }
            }
        }

    }

}