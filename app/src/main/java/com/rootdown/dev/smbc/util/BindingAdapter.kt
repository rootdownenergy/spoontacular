package com.rootdown.dev.smbc.lib.helpers

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView, url: String) {
    Glide.with(imageView.context)
        .load("https://spoonacular.com/recipeImages/$url")
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(imageView)
}