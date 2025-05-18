package com.ugurtansal.task_7.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.ugurtansal.task_7.R
import com.ugurtansal.task_7.databinding.FragmentUpdateBinding


class UpdateFragment : Fragment() {
    private lateinit var binding: FragmentUpdateBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentUpdateBinding.inflate(inflater, container, false)

        val bundle:UpdateFragmentArgs by navArgs() //Gelen veriyi almak için ön hazırlık yaptık
        val toDo=bundle.todo//Gelen veriyi aldık

        binding.txtToDo.setText(toDo.task)

        return binding.root
    }


}