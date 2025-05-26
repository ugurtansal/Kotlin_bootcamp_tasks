package com.ugurtansal.graduation_project.ui.viewModel

import androidx.lifecycle.MutableLiveData
import com.ugurtansal.graduation_project.data.entity.Dish
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class HomeViewModel {
    var dishesList= MutableLiveData<List<Dish>>()

    init {
        loadDishes()
    }


    fun loadDishes() {
        // Logic to load dishes from repository or database
        // For example:
        // dishesList.value = dishRepository.getAllDishes()
    }

    fun search(searchedWord: String) {
        // Logic to search dishes based on the searched word
        // For example:
        // dishesList.value = dishRepository.searchDishes(searchedWord)
    }

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

    }
}