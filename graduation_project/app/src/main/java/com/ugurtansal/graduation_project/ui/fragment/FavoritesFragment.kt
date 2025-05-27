package com.ugurtansal.graduation_project.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ugurtansal.graduation_project.R
import com.ugurtansal.graduation_project.data.entity.Dish
import com.ugurtansal.graduation_project.databinding.FragmentFavoritesBinding
import com.ugurtansal.graduation_project.databinding.FragmentHomeBinding
import com.ugurtansal.graduation_project.ui.adapter.CartAdapter
import com.ugurtansal.graduation_project.ui.viewModel.FavoritesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesFragment : Fragment() {
    private lateinit var binding: FragmentFavoritesBinding
    private lateinit var viewModel: FavoritesViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentFavoritesBinding.inflate(inflater, container, false)

//        val dishes=listOf<Dish>(
//            Dish(0, "Izgara Somon", 150.0,"izgarasomon.png"),
//            Dish(0, "Izgara Tavuk", 120.0,"izgaratavuk.png"),
//            Dish(0, "Köfte", 100.0,"kofte.png"),
//            Dish(0, "Lazanya", 130.0,"lazanya.png"),
//            Dish(0, "Makarna", 80.0,"makarna.png"),
//            Dish(0, "Pizza", 90.0,"pizza.png"),
//            Dish(0, "Pizza", 90.0,"pizza.png"),
//            Dish(0, "Pizza", 90.0,"pizza.png"),
//            Dish(0, "Pizza", 90.0,"pizza.png")
//        )

//        val adapter= CartAdapter(requireContext(),dishes,"favorite")
//        binding.favoritesRv.adapter= adapter
//
//        binding.favoritesRv.layoutManager = LinearLayoutManager(requireContext())

        return binding.root
    }


}