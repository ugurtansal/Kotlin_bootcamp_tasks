package com.ugurtansal.task_7.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.ugurtansal.task_7.data.entity.ToDo
import com.ugurtansal.task_7.databinding.CardDesignBinding
import com.ugurtansal.task_7.ui.viewModel.MainViewModel
import com.ugurtansal.task_7.ui.fragment.MainFragmentDirections
import com.ugurtansal.task_7.utils.pass

class ToDoAdapter(var mContext: Context, var toDoList: List<ToDo>, var viewModel: MainViewModel)
    : RecyclerView.Adapter<ToDoAdapter.CardDesignHolder>()
{

    inner class CardDesignHolder (var design: CardDesignBinding): RecyclerView.ViewHolder(design.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {

        val design= CardDesignBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardDesignHolder(design)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {

        val todo= toDoList.get(position) //0,1,2
        val t=holder.design

        t.toDoTask.text= todo.task

        t.imageViewDelete.setOnClickListener {
            Snackbar.make(it,"Do you want to remove ${todo.task}?", Snackbar.LENGTH_SHORT)
                .setAction("Yes") {
                    viewModel.delete(todo.id);
                }.show()
        }

        t.imageViewEdit.setOnClickListener {
            val pass= MainFragmentDirections.mainToUpdate(todo= todo)
            Navigation.pass(it,pass)
        }
    }

    override fun getItemCount(): Int {

        return toDoList.size
    }


}