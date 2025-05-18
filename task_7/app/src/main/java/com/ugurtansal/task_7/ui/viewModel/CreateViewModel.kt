package com.ugurtansal.task_7.ui.viewModel

import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

@HiltViewModel
class CreateViewModel @Inject constructor(var toDoRepository: ToDoRepository) : ViewModel() {

    fun save(task: String) {
        CoroutineScope(Dispatchers.Main).launch {
            toDoRepository.save(task)
        }
    }
}