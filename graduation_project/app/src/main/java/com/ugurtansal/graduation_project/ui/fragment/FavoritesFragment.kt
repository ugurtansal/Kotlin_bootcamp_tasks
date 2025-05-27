package com.ugurtansal.graduation_project.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ugurtansal.graduation_project.R
import com.ugurtansal.graduation_project.data.entity.Dish
import com.ugurtansal.graduation_project.databinding.FragmentFavoritesBinding
import com.ugurtansal.graduation_project.databinding.FragmentHomeBinding
import com.ugurtansal.graduation_project.ui.adapter.CartAdapter
import com.ugurtansal.graduation_project.ui.adapter.FavoriteAdapter
import com.ugurtansal.graduation_project.ui.viewModel.FavoritesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesFragment : Fragment() {
    private lateinit var binding: FragmentFavoritesBinding
    private lateinit var viewModel: FavoritesViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: FavoritesViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentFavoritesBinding.inflate(inflater, container, false)

        viewModel.favoritesList.observe(viewLifecycleOwner) {

            val adapter = FavoriteAdapter(requireContext(), it, viewModel)
            binding.favoritesRv.adapter = adapter
            binding.favoritesRv.layoutManager = LinearLayoutManager(requireContext())
        }




        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadFavorites()
    }


}