package com.ugurtansal.graduation_project.data.dataSource

import android.util.Log
import com.ugurtansal.graduation_project.data.entity.Cart
import com.ugurtansal.graduation_project.retrofit.CartDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CartDataSource (var cartDao: CartDao){
    val userName="ugur_tans";

    suspend fun loadCartItems(): List<Cart> = withContext(Dispatchers.IO) {
        // Simulate network call to load cart items
        return@withContext  cartDao.loadCart(userName).cartDishes
    }

    suspend fun addToCart(foodName: String, foodImage: String, foodPrice: Int, orderCount: Int) {

        val crudResponse = cartDao.addToCart(foodName, foodImage, foodPrice, orderCount, userName)
        Log.e("CartDataSource", "Item added to cart: $foodName, Price: $foodPrice, Count: $orderCount")
    }

    suspend fun removeFromCart(cartDishId: Int) {
        val crudResponse = cartDao.removeFromCart(cartDishId, userName)
    }

    suspend fun updateCartItemQuantity(dishId: Int, quantity: Int) {
        // Simulate network call to update the quantity of a dish in the cart
    }


}