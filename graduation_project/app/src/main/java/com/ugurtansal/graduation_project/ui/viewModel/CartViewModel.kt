package com.ugurtansal.graduation_project.ui.viewModel

import androidx.lifecycle.MutableLiveData
import com.ugurtansal.graduation_project.data.entity.Dish
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class CartViewModel {
    var cartList= MutableLiveData<List<Dish>>()

    init {
        loadCartItems()
    }


    fun loadCartItems() {

    }

    fun removeFromCart(dish: Dish) {
        // Logic to remove dish from cart
    }

    fun updateCartItemQuantity(dish: Dish, quantity: Int) {
        // Logic to update the quantity of a dish in the cart
    }
}