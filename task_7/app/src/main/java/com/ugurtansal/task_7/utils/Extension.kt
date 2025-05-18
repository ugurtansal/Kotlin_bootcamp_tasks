package com.ugurtansal.task_7.utils

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun Navigation.pass(it: View, id: Int) {
    findNavController(it).navigate(id)
}

fun Navigation.pass(it: View, id: NavDirections){
    findNavController(it).navigate(id);
}