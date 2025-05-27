package com.ugurtansal.graduation_project.data.repo

import com.ugurtansal.graduation_project.data.dataSource.CartDataSource
import com.ugurtansal.graduation_project.data.entity.Cart

class CartRepository(var cartDataSource: CartDataSource) {


    suspend fun loadCartItems() : List<Cart> = cartDataSource.loadCartItems()


    suspend fun addToCart(foodName: String, foodImage: String, foodPrice: Int, orderCount: Int) {
        cartDataSource.addToCart(foodName, foodImage, foodPrice, orderCount)
    }

    suspend fun removeFromCart(cartDishId: Int) {
        cartDataSource.removeFromCart(cartDishId)
    }


    suspend fun updateCartItemQuantity(dishId: Int, quantity: Int) {
        cartDataSource.updateCartItemQuantity(dishId, quantity)
    }



}