package com.ugurtansal.task_7.di

import android.content.Context
import androidx.room.Room
import com.ugurtansal.task_7.data.dataSource.ToDoDataSource
import com.ugurtansal.task_7.data.repo.ToDoRepository
import com.ugurtansal.task_7.room.Database
import com.ugurtansal.task_7.room.ToDoDao
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
    fun provideToDoRepository(toDoDataSource: ToDoDataSource): ToDoRepository {
        return ToDoRepository(toDoDataSource)
    }

    @Provides
    @Singleton
    fun provideToDoDataSource(toDoDao: ToDoDao): ToDoDataSource {
        return ToDoDataSource(toDoDao)
    }

    @Provides
    @Singleton
    fun provideToDoDao(@ApplicationContext context: Context): ToDoDao {
       val database= Room.databaseBuilder(context, Database::class.java,"task.db").createFromAsset("task.db").build();
        return database.getToDoDao()
    }
}