package com.ugurtansal.graduation_project.data.repo

import android.util.Log
import com.ugurtansal.graduation_project.data.dataSource.CartDataSource
import com.ugurtansal.graduation_project.data.entity.Cart

class CartRepository(var cartDataSource: CartDataSource) {


    suspend fun loadCartItems() : List<Cart> = cartDataSource.loadCartItems()


    suspend fun addToCart(foodName: String, foodImage: String, foodPrice: Int, orderCount: Int) {
        cartDataSource.addToCart(foodName, foodImage, foodPrice, orderCount)
        Log.e("CartRepository", "Item added to cart: $foodName, Price: $foodPrice, Count: $orderCount")
    }

    suspend fun removeFromCart(cartDishId: Int) {
        cartDataSource.removeFromCart(cartDishId)
    }


    suspend fun updateCartItemQuantity(cartDishId: Int,foodName: String, foodImage: String, foodPrice: Int, quantity: Int) {
        cartDataSource.removeFromCart(cartDishId);
        cartDataSource.addToCart(foodName, foodImage, foodPrice, quantity)

    }



}