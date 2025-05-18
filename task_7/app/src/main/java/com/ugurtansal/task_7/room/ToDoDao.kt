package com.ugurtansal.task_7.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.ugurtansal.task_7.data.entity.ToDo

@Dao
interface ToDoDao {

    @Query("SELECT * FROM Task")  //For don't get error must add @Entity(tableName = "Task") to ToDo class
    suspend fun loadTasks(): List<ToDo>


    @Insert
    suspend fun addTask(task: ToDo)

    @Update
    suspend fun updateTask(task: ToDo)


    @Delete
    suspend fun deleteTask(task: ToDo)


    @Query("SELECT * FROM Task WHERE task LIKE '%' || :searchedWord ||'%'")
    suspend fun search(searchedWord: String): List<ToDo>
}