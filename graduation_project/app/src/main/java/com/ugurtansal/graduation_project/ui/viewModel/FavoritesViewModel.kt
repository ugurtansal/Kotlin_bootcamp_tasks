package com.ugurtansal.graduation_project.ui.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ugurtansal.graduation_project.data.entity.Dish
import com.ugurtansal.graduation_project.data.entity.Favorites
import com.ugurtansal.graduation_project.data.repo.FavoritesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(var favoritesRepository: FavoritesRepository) : ViewModel() {
    private var _favoritesList= MutableLiveData<List<Favorites>>()
    val favoritesList: LiveData<List<Favorites>>
        get() = _favoritesList

    init {
        loadFavorites()
    }


    fun loadFavorites() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                _favoritesList.value = favoritesRepository.loadFavorites()
                Log.e("FavoritesViewModel", "Favorites loaded: ${_favoritesList.value?.size} items")
            } catch (e: Exception) {
                Log.e("FavoritesViewModel", "Error loading favorites", e)
                e.printStackTrace() // Handle the exception appropriately
            }
        }
    }


    fun delete(dishName: String) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                favoritesRepository.deleteFavorite(dishName)
                loadFavorites() // Refresh the favorites list after deletion
            } catch (e: Exception) {
                e.printStackTrace() // Handle the exception appropriately
            }
        }
    }

    fun addToFavorites(dish: Dish) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                favoritesRepository.saveFavorite(dish.name, dish.image, dish.price.toInt(), dish.id)
                loadFavorites() // Refresh the favorites list after adding
            } catch (e: Exception) {
                e.printStackTrace() // Handle the exception appropriately
            }
        }
    }
}