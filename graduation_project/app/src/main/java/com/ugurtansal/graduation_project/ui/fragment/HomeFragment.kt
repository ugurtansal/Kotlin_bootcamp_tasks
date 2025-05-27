package com.ugurtansal.graduation_project.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ugurtansal.graduation_project.R
import com.ugurtansal.graduation_project.data.entity.Dish
import com.ugurtansal.graduation_project.databinding.FragmentHomeBinding
import com.ugurtansal.graduation_project.ui.adapter.DishAdapter
import com.ugurtansal.graduation_project.ui.viewModel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: HomeViewModel by viewModels()
        viewModel = tempViewModel

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentHomeBinding.inflate(inflater, container, false)

        viewModel.dishesList.observe(viewLifecycleOwner) {
            val adapter = DishAdapter(requireContext(), it,viewModel)
                binding.dishRv.adapter = adapter
                binding.dishRv.layoutManager = GridLayoutManager(requireContext(), 2)
        }





        //Burada localden çekilen favorilerimizi listeleyip adaptere göndereceğiz !!!!!!!!!!!!!!!!!!!!!!!!!!






        return binding.root
    }


    override fun onResume() {
        super.onResume()
        viewModel.loadDishes()
    }


}