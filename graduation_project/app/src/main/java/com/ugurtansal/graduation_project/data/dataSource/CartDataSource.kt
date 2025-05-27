package com.ugurtansal.graduation_project.data.dataSource

import com.ugurtansal.graduation_project.data.entity.Cart
import com.ugurtansal.graduation_project.retrofit.CartDao

class CartDataSource (var cartDao: CartDao){

    suspend fun loadCartItems(): List<Cart> {
        // Simulate network call to load cart items
        return listOf(
            Cart(1, "Product 1", "a", "a","s","c"),
            Cart(2, "Product 2", "s", "x", "s","c"),
        )
    }

    suspend fun addToCart(dishId: Int, quantity: Int) {

    }

    suspend fun removeFromCart(dishId: Int) {
        // Simulate network call to remove a dish from the cart
    }

    suspend fun updateCartItemQuantity(dishId: Int, quantity: Int) {
        // Simulate network call to update the quantity of a dish in the cart
    }


}