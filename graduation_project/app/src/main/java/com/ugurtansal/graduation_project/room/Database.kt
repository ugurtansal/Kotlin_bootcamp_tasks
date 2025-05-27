package com.ugurtansal.graduation_project.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ugurtansal.graduation_project.data.entity.Favorites

@Database(entities = [Favorites::class], version = 1)
abstract class Database : RoomDatabase(){

    abstract fun getFavoritesDao(): FavoritesDao
}