package com.ugurtansal.task_7.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.ugurtansal.task_7.databinding.FragmentCreateBinding
import com.ugurtansal.task_7.ui.viewModel.CreateViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateFragment : Fragment() {
    private lateinit var binding: FragmentCreateBinding
    private lateinit var  viewModel: CreateViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentCreateBinding.inflate(inflater ,container, false)


        binding.btnSave.setOnClickListener {
            val task= binding.txtToDo.text.toString()
            if (task.isNotEmpty()){
                viewModel.save(task)
                binding.txtToDo.setText("")

                Toast.makeText(requireContext(), "Task Created", Toast.LENGTH_SHORT).show();
            }
        }

        return binding.root;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: CreateViewModel by viewModels()
        viewModel= tempViewModel
    }


}