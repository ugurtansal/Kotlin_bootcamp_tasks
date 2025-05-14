package com.ugurtansal.task_6.data

import java.io.Serializable

data class Category (
    var categoryId: Int,
    var categoryName: String,
    var categoryImage: String
) : Serializable{


}