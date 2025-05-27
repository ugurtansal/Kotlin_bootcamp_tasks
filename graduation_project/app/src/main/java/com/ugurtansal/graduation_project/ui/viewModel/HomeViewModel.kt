package com.ugurtansal.graduation_project.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ugurtansal.graduation_project.data.entity.Dish
import com.ugurtansal.graduation_project.data.repo.CartRepository
import com.ugurtansal.graduation_project.data.repo.DishRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(var dishRepository: DishRepository,var cartRepository: CartRepository) : ViewModel() {
    var dishesList= MutableLiveData<List<Dish>>()

    init {
        loadDishes()
    }


    fun loadDishes() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                dishesList.value = dishRepository.loadDishes() // Trigger the loading of dishes
            } catch (e: Exception) {
                e.printStackTrace() // Handle the exception appropriately
            }
        }
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

    fun addToCart(dish: Dish, orderCount: Int = 1) {
        CoroutineScope(Dispatchers.Main).launch {
            cartRepository.addToCart(dish.name, dish.image, dish.price.toInt(),orderCount )
        }
    }
}