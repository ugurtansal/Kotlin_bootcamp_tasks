package com.ugurtansal.graduation_project.data.repo

import com.ugurtansal.graduation_project.data.dataSource.DishDataSource

class DishRepository(var dishDataSource: DishDataSource) {

    suspend fun loadDishes() = dishDataSource.loadDishes()

    suspend fun search(query: String) = dishDataSource.search(query)
}