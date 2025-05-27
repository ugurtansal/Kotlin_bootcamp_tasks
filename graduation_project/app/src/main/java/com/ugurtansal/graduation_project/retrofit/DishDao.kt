package com.ugurtansal.graduation_project.retrofit

import com.ugurtansal.graduation_project.data.entity.Dish
import com.ugurtansal.graduation_project.data.entity.DishResponse
import com.ugurtansal.graduation_project.data.repo.DishRepository
import retrofit2.http.GET

interface DishDao {

    @GET("yemekler/tumYemekleriGetir.php")
    suspend fun loadDishes(): DishResponse




}