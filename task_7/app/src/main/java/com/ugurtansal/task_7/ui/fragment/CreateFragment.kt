package com.ugurtansal.task_7.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ugurtansal.task_7.R
import com.ugurtansal.task_7.databinding.FragmentCreateBinding


class CreateFragment : Fragment() {
    private lateinit var binding: FragmentCreateBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentCreateBinding.inflate(inflater ,container, false)

        return binding.root;
    }


}