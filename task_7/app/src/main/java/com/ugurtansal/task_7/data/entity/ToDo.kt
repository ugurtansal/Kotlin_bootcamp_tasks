package com.ugurtansal.task_7.data.entity

import androidx.room.Entity
import java.io.Serializable

@Entity(tableName = "Task")
data class ToDo(
    var id: Int,
    var task: String,

) : Serializable{
}