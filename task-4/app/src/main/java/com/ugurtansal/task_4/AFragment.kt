package com.ugurtansal.task_4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.Navigation
import com.ugurtansal.task_4.databinding.FragmentABinding


class AFragment : Fragment() {
    private lateinit var binding: FragmentABinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentABinding.inflate(inflater, container, false)

        binding.buttonB.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.A_to_B_pass)
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