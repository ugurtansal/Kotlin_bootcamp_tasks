package com.ugurtansal.graduation_project.data.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Cart (@SerializedName("sepet_yemek_id") var cartDishId: Int, @SerializedName("yemek_adi") var dishName: String,
                 @SerializedName("yemek_resim_adi") var dishImage: String,@SerializedName("yemek_fiyat") var dishPrice: String,
                 @SerializedName("yemek_siparis_adet") var dishQuantity: String, @SerializedName("kullanici_adi") var userName: String)
    :Serializable{
}