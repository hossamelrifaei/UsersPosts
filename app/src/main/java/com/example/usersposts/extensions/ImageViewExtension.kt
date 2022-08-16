package com.example.usersposts.extensions

import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


fun AppCompatImageView.load(url: String?, isCircle: Boolean) {
    val options = RequestOptions()
    if (isCircle) {
        options.circleCrop()
    }else{
        options.centerCrop()
    }
    Glide.with(this.context)
        .load(url)
        .apply(options)
        .into(this)
}