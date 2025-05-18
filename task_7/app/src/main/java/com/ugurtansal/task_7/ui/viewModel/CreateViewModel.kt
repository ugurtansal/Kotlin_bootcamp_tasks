package com.ugurtansal.task_7.ui.viewModel

import androidx.lifecycle.ViewModel
import com.ugurtansal.task_7.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateViewModel @Inject constructor(var toDoRepository: ToDoRepository) : ViewModel() {

    fun save(task: String) {
        CoroutineScope(Dispatchers.Main).launch {
            toDoRepository.save(task)
        }
    }
}