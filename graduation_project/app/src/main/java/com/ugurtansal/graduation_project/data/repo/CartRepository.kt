package com.ugurtansal.graduation_project.data.repo

import com.ugurtansal.graduation_project.data.dataSource.CartDataSource

class CartRepository(var cartDataSource: CartDataSource) {


    suspend fun loadCartItems() {
        cartDataSource.loadCartItems()
    }

    suspend fun addToCart(dishId: Int, quantity: Int) {
        cartDataSource.addToCart(dishId, quantity)
    }

    suspend fun removeFromCart(dishId: Int) {
        cartDataSource.removeFromCart(dishId)
    }





    suspend fun updateCartItemQuantity(dishId: Int, quantity: Int) {
        cartDataSource.updateCartItemQuantity(dishId, quantity)
    }



}