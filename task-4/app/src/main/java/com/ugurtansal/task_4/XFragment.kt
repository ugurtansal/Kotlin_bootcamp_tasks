package com.ugurtansal.task_4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.Navigation
import com.ugurtansal.task_4.databinding.FragmentMainBinding
import com.ugurtansal.task_4.databinding.FragmentXBinding

class XFragment : Fragment() {
    private lateinit var binding: FragmentXBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentXBinding.inflate(inflater, container, false)

        binding.buttonXtoY.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.X_to_Y_pass)
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