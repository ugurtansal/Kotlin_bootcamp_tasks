package com.ugurtansal.graduation_project.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import org.jetbrains.annotations.NotNull
import javax.annotation.Nonnull

@Entity(tableName = "Favorites")
data class Favorites  (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "name")@NotNull var name: String,
    @ColumnInfo(name = "image")@NotNull var image: String,
    @ColumnInfo(name="price")@NotNull var price: Int,
    @ColumnInfo(name="id") var id: Int? = null
): Serializable{
}