package com.ugurtansal.task_4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.Navigation
import com.ugurtansal.task_4.databinding.FragmentBBinding


class BFragment : Fragment() {
    private lateinit var binding: FragmentBBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentBBinding.inflate(inflater, container, false)

        binding.buttonBtoY.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.B_to_Y_pass);
        }

        val backPress= object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Handle the back press event
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, backPress)

        return binding.root
    }


}