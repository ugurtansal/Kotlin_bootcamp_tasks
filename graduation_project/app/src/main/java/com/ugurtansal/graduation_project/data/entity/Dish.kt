package com.ugurtansal.graduation_project.data.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Dish(@SerializedName("yemek_id") var id: Int, @SerializedName("yemek_adi") var name: String, @SerializedName("yemek_fiyat") var price: String,
                @SerializedName("yemek_resim_adi") var image: String) : Serializable {

}