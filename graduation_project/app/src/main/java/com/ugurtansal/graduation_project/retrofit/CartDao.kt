package com.ugurtansal.graduation_project.retrofit

import com.ugurtansal.graduation_project.data.entity.CRUDResponse
import com.ugurtansal.graduation_project.data.repo.CartRepository
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface CartDao {

    @GET("yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    suspend fun loadCart(@Field("kullanici_adi") userName: String): CartRepository


    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    suspend fun addToCart(
        @Field("yemek_adi") foodName: String,
        @Field("yemek_resim_adi") foodImage: String,
        @Field("yemek_fiyat") foodPrice: Int,
        @Field("yemek_siparis_adet") orderCount: Int,
        @Field("kullanici_adi") userName: String
    ): CRUDResponse


    @POST("yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    suspend fun removeFromCart(
        @Field("sepet_yemek_id") cartFoodId: Int,
        @Field("kullanici_adi") userName: String
    ): CRUDResponse
}