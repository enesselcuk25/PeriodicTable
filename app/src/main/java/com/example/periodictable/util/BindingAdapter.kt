package com.example.periodictable.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.periodictable.R

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("app:loadImage")
    fun ImageView.loadImage(url:String){
        Glide.with(this)
            .load(url)
            .transition(DrawableTransitionOptions.withCrossFade())
            .error(R.drawable.question_icon)
            .into(this)
    }
}