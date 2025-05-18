package com.ugurtansal.task_7.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "Task")
data class ToDo(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id")@NotNull var id: Int,
    @ColumnInfo(name = "name")@NotNull var task: String,

    ) : Serializable{
}