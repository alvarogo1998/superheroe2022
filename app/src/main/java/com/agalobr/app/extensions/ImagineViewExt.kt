package com.agalobr.app.extensions

import com.bumptech.glide.Glide

fun imageView,loadUrl(urlImage: String){
    Glide.with(this).load(urlImage).into(this);
}

