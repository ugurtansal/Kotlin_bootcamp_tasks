package com.ugurtansal.graduation_project.ui.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
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

    private val _cartList = MutableLiveData<List<Cart>>()
    val cartList: LiveData<List<Cart>> get() = _cartList



    init {
        loadCartItems()
    }


    fun loadCartItems() {

        CoroutineScope(Dispatchers.Main).launch {
            try {
                _cartList.value = cartRepository.loadCartItems()
                for (cart in cartList.value!!) {
                    Log.e("CartViewModel", "Dish ID: ${cart.cartDishId}, Dish Name: ${cart.dishName}")
                }
            } catch (e: Exception) {
                Log.e("CartViewModel", "CartViewModel de hata olustu: ${e.message}")
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

    fun updateCartItemQuantity(cartDish: Cart, quantity: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                cartRepository.updateCartItemQuantity(cartDish.cartDishId, cartDish.dishName, cartDish.dishImage, cartDish.dishPrice.toInt(), quantity)
                loadCartItems() // Refresh the cart items after updating
            } catch (e: Exception) {
                Log.e("CartViewModel", "Error updating cart item quantity: ${e.message}")
                e.printStackTrace()
            }
        }
    }
}