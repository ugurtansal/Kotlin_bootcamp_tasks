package com.ugurtansal.task_7.ui.viewModel

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(var toDoRepository: ToDoRepository) : ViewModel() {
    val toDoList = MutableLiveData<List<ToDo>>();

    init {
        loadTasks();
    }


    fun delete(taskId: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            toDoRepository.delete(taskId);
            loadTasks();
        }
    }

   fun loadTasks() {
       CoroutineScope(Dispatchers.Main).launch {
            toDoList.value = toDoRepository.loadTasks();
       }
   }

    fun search(searchedWord: String) {
        CoroutineScope(Dispatchers.Main).launch {
            toDoList.value = toDoRepository.search(searchedWord);
        }
    }
}