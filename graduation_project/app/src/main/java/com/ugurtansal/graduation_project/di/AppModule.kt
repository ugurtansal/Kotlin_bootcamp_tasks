package com.ugurtansal.graduation_project.di

import com.ugurtansal.graduation_project.data.dataSource.CartDataSource
import com.ugurtansal.graduation_project.data.dataSource.DishDataSource
import com.ugurtansal.graduation_project.data.repo.CartRepository
import com.ugurtansal.graduation_project.data.repo.DishRepository
import com.ugurtansal.graduation_project.retrofit.ApiUtils
import com.ugurtansal.graduation_project.retrofit.CartDao
import com.ugurtansal.graduation_project.retrofit.DishDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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


}