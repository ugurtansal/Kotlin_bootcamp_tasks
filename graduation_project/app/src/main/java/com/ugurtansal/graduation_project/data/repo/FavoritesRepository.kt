package com.ugurtansal.graduation_project.data.repo

import com.ugurtansal.graduation_project.data.dataSource.FavoritesDataSource
import com.ugurtansal.graduation_project.data.entity.Favorites

class FavoritesRepository(var favoritesDataSource: FavoritesDataSource) {

    suspend fun saveFavorite(favoriteName: String, favoriteImage: String, price: Int, id: Int) =
        favoritesDataSource.save(favoriteName, favoriteImage, price, id)

    suspend fun deleteFavorite(favoriteName: String) = favoritesDataSource.delete(favoriteName)

    suspend fun loadFavorites(): List<Favorites> = favoritesDataSource.loadFavorites()

}