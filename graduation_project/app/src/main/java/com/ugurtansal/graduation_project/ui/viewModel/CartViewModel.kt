package com.ugurtansal.graduation_project.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ugurtansal.graduation_project.data.entity.Cart
import com.ugurtansal.graduation_project.data.entity.Dish
import com.ugurtansal.graduation_project.data.repo.CartRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(var cartRepository: CartRepository) : ViewModel() {
    var cartList= MutableLiveData<List<Cart>>()

    init {
        loadCartItems()
    }


    fun loadCartItems() {

        CoroutineScope(Dispatchers.Main).launch {
            try {
                cartList.value = cartRepository.loadCartItems()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }

    fun removeFromCart(cartDishId: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                cartRepository.removeFromCart(cartDishId)
                loadCartItems() // Refresh the cart items after removal
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun updateCartItemQuantity(dish: Dish, quantity: Int) {
        // Logic to update the quantity of a dish in the cart
    }
}