package com.ugurtansal.task_7.data.dataSource

import com.ugurtansal.task_7.data.entity.ToDo
import com.ugurtansal.task_7.room.ToDoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDoDataSource (var toDoDao: ToDoDao) {

    suspend fun save(task: String) {
        val newTask = ToDo(0, task)

        toDoDao.addTask(newTask)
    }

    suspend fun update(taskId: Int, task: String) {
        val updatedTask = ToDo(taskId, task)
        toDoDao.updateTask(updatedTask)
    }

    suspend fun delete(taskId: Int) {
        val taskToDelete = ToDo(taskId, "")
        toDoDao.deleteTask(taskToDelete)
    }

    suspend fun loadTasks(): List<ToDo> = withContext(Dispatchers.IO) {
        return@withContext toDoDao.loadTasks()
    }

    suspend fun search(searchedWord: String): List<ToDo> = withContext(Dispatchers.IO) {
        return@withContext toDoDao.search(searchedWord)
    }
}