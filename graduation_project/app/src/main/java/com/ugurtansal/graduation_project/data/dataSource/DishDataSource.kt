package com.ugurtansal.graduation_project.data.dataSource

import com.ugurtansal.graduation_project.data.entity.Dish
import com.ugurtansal.graduation_project.retrofit.DishDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DishDataSource (var dishDao: DishDao) {

    suspend fun loadDishes(): List<Dish> = withContext(Dispatchers.IO) {
        return@withContext dishDao.loadDishes().dishes
    }

    suspend fun search(searchedWord: String): List<String> {
        // Simulate a search operation
        val allDishes = listOf("Pizza", "Burger", "Pasta", "Salad")
        return allDishes.filter { it.contains(searchedWord, ignoreCase = true) }
    }
}