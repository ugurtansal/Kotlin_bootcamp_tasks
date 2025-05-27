package com.ugurtansal.graduation_project.di

import android.content.Context
import androidx.room.Room
import com.ugurtansal.graduation_project.data.dataSource.CartDataSource
import com.ugurtansal.graduation_project.data.dataSource.DishDataSource
import com.ugurtansal.graduation_project.data.dataSource.FavoritesDataSource
import com.ugurtansal.graduation_project.data.repo.CartRepository
import com.ugurtansal.graduation_project.data.repo.DishRepository
import com.ugurtansal.graduation_project.data.repo.FavoritesRepository
import com.ugurtansal.graduation_project.retrofit.ApiUtils
import com.ugurtansal.graduation_project.retrofit.CartDao
import com.ugurtansal.graduation_project.retrofit.DishDao
import com.ugurtansal.graduation_project.room.Database
import com.ugurtansal.graduation_project.room.FavoritesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideDishRepository(dishDataSource: DishDataSource): DishRepository {
        return DishRepository(dishDataSource)
    }

    @Provides
    @Singleton
    fun provideDishDataSource(dishDao: DishDao): DishDataSource {
        return DishDataSource(dishDao)
    }

    @Provides
    @Singleton
    fun provideDishDao(): DishDao {

        return ApiUtils.getDishDao()
    }

    @Provides
    @Singleton
    fun provideCartRepository(cartDataSource: CartDataSource): CartRepository {
        return CartRepository(cartDataSource)
    }

    @Provides
    @Singleton
    fun provideCartDataSource(cartDao: CartDao): CartDataSource {
        return CartDataSource(cartDao)
    }


    @Provides
    @Singleton
    fun provideCartDao(): CartDao {
        return ApiUtils.getCartDao()
    }


    @Provides
    @Singleton
    fun provideFavoritesRepository(favoritesDataSource: FavoritesDataSource): FavoritesRepository {
        return FavoritesRepository(favoritesDataSource)
    }

    @Provides
    @Singleton
    fun provideFavoritesDataSource(favoritesDao: FavoritesDao): FavoritesDataSource {
        return FavoritesDataSource(favoritesDao)
    }


    @Provides
    @Singleton
    fun provideFavoritesDao(@ApplicationContext context: Context): FavoritesDao {
        val database= Room.databaseBuilder(context, Database::class.java,"favorites_grad_project.db").createFromAsset("favorites_grad_project.db").build()

        return database.getFavoritesDao()
    }

}