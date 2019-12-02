package com.maxtayler.punk.viewbinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.api.load

object ViewBindingAdapters {

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun loadImage(view: ImageView, url: String) {
        view.load(url)
    }
}