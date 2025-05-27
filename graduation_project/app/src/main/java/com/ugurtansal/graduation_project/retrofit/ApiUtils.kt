package com.ugurtansal.graduation_project.retrofit

class ApiUtils {

    companion object{
        val BASE_URL = "http://kasimadalan.pe.hu/"

        fun getDishDao(): DishDao {
            return RetrofitClient.getClient(BASE_URL).create(DishDao::class.java)
        }

        fun getCartDao(): CartDao {
            return RetrofitClient.getClient(BASE_URL).create(CartDao::class.java)
        }
    }
}