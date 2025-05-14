package com.ugurtansal.task_6.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ugurtansal.task_6.data.Category
import com.ugurtansal.task_6.databinding.CardDesignBinding

class CategoryAdapter(var mContext: Context, var categoryList:List<Category>)
    : RecyclerView.Adapter<CategoryAdapter.CardDesignHolder>()
{
        inner class CardDesignHolder(var design: CardDesignBinding) : RecyclerView.ViewHolder(design.root)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
            val design= CardDesignBinding.inflate(LayoutInflater.from(mContext), parent, false)
            return CardDesignHolder(design)
        }

        override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
            val category=categoryList.get(position)
            val t=holder.design
            t.imageView.setImageResource(
                mContext.resources.getIdentifier(category.categoryImage,"drawable",mContext.packageName)
            )

        }

        override fun getItemCount(): Int {
            return categoryList.size
        }


}