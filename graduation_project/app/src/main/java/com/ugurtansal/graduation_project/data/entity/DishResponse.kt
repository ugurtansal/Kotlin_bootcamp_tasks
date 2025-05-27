package com.ugurtansal.graduation_project.data.entity

import com.google.gson.annotations.SerializedName

data class DishResponse (@SerializedName("yemekler") var dishes:List<Dish>, var success:Int){
}