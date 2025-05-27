package com.ugurtansal.graduation_project.utils

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import com.bumptech.glide.Glide
import com.ugurtansal.graduation_project.R

fun showImg(resimAdi:String,imageView: ImageView){
    val url="http://kasimadalan.pe.hu/yemekler/resimler/$resimAdi" // Example URL, replace with actual image URL
    Glide.with(imageView).load(url).override(450,450).into(imageView)
}


fun Navigation.pass(it: View, id:Int){
    findNavController(it).navigate(id);
}

fun Navigation.pass(it: View, id: NavDirections){
    findNavController(it).navigate(id);
}

fun addFavorite(it: View, id: Int) {
    Toast.makeText(it.context, "Added to favorites", Toast.LENGTH_SHORT).show()
}

fun removeFavorite(it: View, id: Int) {
    Toast.makeText(it.context, "Removed from favorites", Toast.LENGTH_SHORT).show()
}


fun ImageView.setupFavoriteToggle(
    initialState: Boolean,
    onAdd: () -> Unit,
    onRemove: () -> Unit
) {
    var isFavorite = initialState
    setImageResource(if (isFavorite) R.drawable.favorite_icn else R.drawable.favorite_border_icn)

    setOnClickListener {
        if (isFavorite) {
            onRemove()
            setImageResource(R.drawable.favorite_border_icn)
        } else {
            onAdd()
            setImageResource(R.drawable.favorite_icn)
        }
        isFavorite = !isFavorite
    }
}

fun addToCart(it: View, id: Int) {
    Toast.makeText(it.context, "Added to cart", Toast.LENGTH_SHORT).show()
}
fun removeFromCart(it: View, id: Int) {
    Toast.makeText(it.context, "Removed from cart", Toast.LENGTH_SHORT).show()
}

fun setupCounter(
    minusBtn: Button,
    plusBtn: Button,
    countTextView: TextView,
    initialValue: Int = 1,
    min: Int = 1,
    max: Int = 99,
    onValueChanged: ((Int) -> Unit)? = null
) {
    var count = initialValue
    countTextView.text = count.toString()

    minusBtn.setOnClickListener {
        if (count > min) {
            count--
            countTextView.text = count.toString()
            onValueChanged?.invoke(count)
        }
    }

    plusBtn.setOnClickListener {
        if (count < max) {
            count++
            countTextView.text = count.toString()
            onValueChanged?.invoke(count)
        }
    }
}

