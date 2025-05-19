package com.ugurtansal.task_7.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ugurtansal.task_7.databinding.FragmentUpdateBinding
import com.ugurtansal.task_7.ui.viewModel.UpdateViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue

@AndroidEntryPoint
class UpdateFragment : Fragment() {
    private lateinit var binding: FragmentUpdateBinding
    private lateinit var viewModel: UpdateViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentUpdateBinding.inflate(inflater, container, false)

        val bundle:UpdateFragmentArgs by navArgs() //Gelen veriyi almak için ön hazırlık yaptık
        val toDo=bundle.todo//Gelen veriyi aldık

        binding.txtToDo.setText(toDo.task)

        binding.btnUpdate.setOnClickListener {
            val task= binding.txtToDo.text.toString()
            if (task.isNotEmpty()){
                viewModel.update(toDo.id,task)
                binding.txtToDo.setText("")

                Toast.makeText(requireContext(), "Task Updated", Toast.LENGTH_SHORT).show();
            }
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: UpdateViewModel by viewModels()
        viewModel= tempViewModel
    }

}