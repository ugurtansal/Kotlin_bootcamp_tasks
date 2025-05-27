package com.ugurtansal.graduation_project.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.ugurtansal.graduation_project.data.entity.Favorites

@Dao
interface FavoritesDao {

@Query("SELECT * FROM favorites")
suspend fun loadFavorites(): List<Favorites>

@Insert
suspend fun saveFavorite(favorites: Favorites)

@Delete
suspend fun deleteFavorite(favorites: Favorites)
}