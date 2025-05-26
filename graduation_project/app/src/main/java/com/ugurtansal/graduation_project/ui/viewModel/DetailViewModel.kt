package com.ugurtansal.graduation_project.ui.viewModel

import com.ugurtansal.graduation_project.data.entity.Dish
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class DetailViewModel {

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

    fun addToCart(dish: Dish) {
        // Logic to add a dish to the cart
        // For example:
        // cartRepository.addToCart(dish)
    }
}