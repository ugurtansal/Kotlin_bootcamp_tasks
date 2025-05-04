package com.ugurtansal.task_4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.ugurtansal.task_4.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentMainBinding.inflate(inflater, container, false)

        binding.buttonA.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.main_to_A_pass)
        };
        binding.buttonX.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.main_to_X_pass)
        }

        return binding.root
    }


    }
