package com.ugurtansal.graduation_project.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

fun showImg(resimAdi:String,imageView: ImageView){
    val url="http://kasimadalan.pe.hu/yemekler/resimler/ayran.png" // Example URL, replace with actual image URL
    Glide.with(imageView).load(url).override(450,450).into(imageView)
}