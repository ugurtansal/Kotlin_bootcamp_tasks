package com.ugurtansal.graduation_project.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.ugurtansal.graduation_project.data.entity.Dish
import com.ugurtansal.graduation_project.data.repo.CartRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(var cartRepository: CartRepository) : ViewModel() {

    fun addToFavorites(dish: Dish) {
        // Logic to add a dish to favorites
        // For example:
        // dishRepository.addToFavorites(dish)
    }

    fun removeFromFavorites(dish: Dish) {
        // Logic to remove a dish from favorites
        // For example:
        // dishRepository.removeFromFavorites(dish)
    }

    fun addToCart(foodName: String, foodImage: String, foodPrice: Int, orderCount: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val currentCart = cartRepository.loadCartItems()

                val existingDish = currentCart.firstOrNull { it.dishName == foodName }

                if (existingDish != null) {
                    val updatedCount = existingDish.dishQuantity.toInt() + orderCount
                    cartRepository.updateCartItemQuantity(
                        existingDish.cartDishId,
                        foodName,
                        foodImage,
                        foodPrice,
                        updatedCount
                    )
                } else {
                    cartRepository.addToCart(foodName, foodImage, foodPrice, orderCount)
                }
            } catch (e: Exception) {
                Log.e("DetailViewModel", "Error adding to cart: ${e.message}")
            }
        }
    }
}