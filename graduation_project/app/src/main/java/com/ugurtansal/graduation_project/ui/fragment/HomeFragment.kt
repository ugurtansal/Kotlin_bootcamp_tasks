package com.ugurtansal.graduation_project.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentHomeBinding.inflate(inflater, container, false)

        val dishes=listOf<Dish>(
            Dish(0, "Izgara Somon", 150.0,"izgarasomon.png"),
            Dish(0, "Izgara Tavuk", 120.0,"izgaratavuk.png"),
            Dish(0, "Köfte", 100.0,"kofte.png"),
            Dish(0, "Lazanya", 130.0,"lazanya.png"),
            Dish(0, "Makarna", 80.0,"makarna.png"),
            Dish(0, "Pizza", 90.0,"pizza.png"),
            Dish(0, "Pizza", 90.0,"pizza.png"),
            Dish(0, "Pizza", 90.0,"pizza.png"),
            Dish(0, "Pizza", 90.0,"pizza.png")
        )

        //Burada localden çekilen favorilerimizi listeleyip adaptere göndereceğiz !!!!!!!!!!!!!!!!!!!!!!!!!!
        val adapter=DishAdapter(requireContext(),dishes)
        binding.dishRv.adapter= adapter

        binding.dishRv.layoutManager = GridLayoutManager(requireContext(), 2)





        return binding.root
    }


}