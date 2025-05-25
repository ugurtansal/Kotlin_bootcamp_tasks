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
import com.ugurtansal.graduation_project.databinding.FragmentCartBinding
import com.ugurtansal.graduation_project.ui.adapter.CartAdapter
import com.ugurtansal.graduation_project.ui.adapter.DishAdapter


class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentCartBinding.inflate(inflater,container,false)

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

        val adapter= CartAdapter(requireContext(),dishes,"CartFragment")
        binding.cartRv.adapter= adapter

        binding.cartRv.layoutManager = LinearLayoutManager(requireContext())

        return binding.root
    }


}