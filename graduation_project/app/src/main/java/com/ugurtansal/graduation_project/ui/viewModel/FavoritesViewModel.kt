package com.ugurtansal.graduation_project.ui.viewModel

import androidx.lifecycle.MutableLiveData
import com.ugurtansal.graduation_project.data.entity.Dish
import dagger.hilt.android.lifecycle.HiltViewModel

//@HiltViewModel
class FavoritesViewModel {
    var favoritesList= MutableLiveData<List<Dish>>()

    init {
        loadFavorites()
    }


    fun loadFavorites() {
        // Logic to load favorite dishes from the repository
        // This should update favoritesList with the loaded data
    }


    fun delete(dishId: Int) {
        // Logic to delete a dish from favorites by its ID
        // After deletion, you may want to call loadFavorites() to refresh the list
    }
}