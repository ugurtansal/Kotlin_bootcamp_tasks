package com.ugurtansal.graduation_project.data.entity

import com.google.gson.annotations.SerializedName

data class CartResponse (@SerializedName("sepet_yemekler") var cartDishes:List<Cart>, var success:Int){
}