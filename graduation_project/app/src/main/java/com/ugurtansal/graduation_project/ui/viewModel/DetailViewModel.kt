package com.ugurtansal.graduation_project.ui.viewModel

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
            cartRepository.addToCart(foodName, foodImage, foodPrice, orderCount)
        }
    }
}