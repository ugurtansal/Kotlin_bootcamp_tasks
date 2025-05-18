package com.ugurtansal.task_7.ui.viewModel

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class UpdateViewModel @Inject constructor(var toDoRepository: ToDoRepository) : ViewModel() {

    fun update(taskId: Int, task: Strin){
        CoroutineScope(Dispatchers.Main).launch {
            toDoRepository.update(taskId,task)
        }
    }
}