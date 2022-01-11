package com.example.githubapp.Extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadimage(uri:String) {
    Glide.with(this).load(uri).into(this)
}