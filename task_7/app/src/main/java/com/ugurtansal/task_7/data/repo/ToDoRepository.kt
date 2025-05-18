package com.ugurtansal.task_7.data.repo

import com.ugurtansal.task_7.data.dataSource.ToDoDataSource
import com.ugurtansal.task_7.data.entity.ToDo

class ToDoRepository (var toDoDataSource: ToDoDataSource) {

    suspend fun save(task: String) {
        toDoDataSource.save(task)
    }

    suspend fun update(taskId: Int, task: String) {
        toDoDataSource.update(taskId, task)
    }

    suspend fun delete(taskId: Int) {
        toDoDataSource.delete(taskId)
    }

    suspend fun loadTasks(): List<ToDo> = toDoDataSource.loadTasks()

    suspend fun search(searchedWord: String) : List<ToDo> = toDoDataSource.search(searchedWord)

}