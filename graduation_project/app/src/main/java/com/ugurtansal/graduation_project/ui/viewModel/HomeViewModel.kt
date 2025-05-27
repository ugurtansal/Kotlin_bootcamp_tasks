package com.ugurtansal.graduation_project.ui.viewModel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ugurtansal.graduation_project.data.entity.Dish
import com.ugurtansal.graduation_project.data.repo.CartRepository
import com.ugurtansal.graduation_project.data.repo.DishRepository
import com.ugurtansal.graduation_project.data.repo.FavoritesRepository
import com.ugurtansal.graduation_project.ui.fragment.HomeFragment
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(var dishRepository: DishRepository,var cartRepository: CartRepository,var favoritesRepository: FavoritesRepository) : ViewModel() {
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


    fun addToFavorites(dish: Dish) {
        CoroutineScope(Dispatchers.Main).launch {
            favoritesRepository.saveFavorite(dish.name, dish.image, dish.price.toInt(), dish.id)
        }
    }

    fun removeFromFavorites(dish: Dish) {
        CoroutineScope(Dispatchers.Main).launch {
            favoritesRepository.deleteFavorite(dish.name)
        }
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