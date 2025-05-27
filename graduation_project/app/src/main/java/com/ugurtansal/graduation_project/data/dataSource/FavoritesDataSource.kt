package com.ugurtansal.graduation_project.data.dataSource

import com.ugurtansal.graduation_project.data.entity.Favorites
import com.ugurtansal.graduation_project.room.FavoritesDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FavoritesDataSource (var favoritesDao: FavoritesDao) {

    suspend fun save(name: String, image: String, price: Int, id: Int) {
        val favorite = Favorites(name, image, price, id)
        favoritesDao.saveFavorite(favorite)
    }


    suspend fun delete(favoriteName: String) {
        val favorite = Favorites(favoriteName, "", 0, 0) // Assuming id and price are not needed for deletion
        favoritesDao.deleteFavorite(favorite)
    }


    suspend fun loadFavorites(): List<Favorites> = withContext(Dispatchers.IO){
       return@withContext favoritesDao.loadFavorites()
    }


}