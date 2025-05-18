package com.ugurtansal.task_7.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ugurtansal.task_7.data.entity.ToDo

@Database(entities = [ToDo::class], version = 1) //This ToDo is our entity class
abstract class Database : RoomDatabase() {
    abstract fun getToDoDao(): ToDoDao //This is our DAO class
    //This function will be used to access the DAO methods
    //We will implement this function in the MainActivity class
}