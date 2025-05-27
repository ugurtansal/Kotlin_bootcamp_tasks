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
import com.ugurtansal.graduation_project.databinding.FragmentCartBinding
import com.ugurtansal.graduation_project.ui.adapter.CartAdapter
import com.ugurtansal.graduation_project.ui.adapter.DishAdapter
import com.ugurtansal.graduation_project.ui.viewModel.CartViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding
    private lateinit var viewModel: CartViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: CartViewModel by viewModels()
        viewModel = tempViewModel

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentCartBinding.inflate(inflater,container,false)

        viewModel.cartList.observe(viewLifecycleOwner) {
            val adapter = CartAdapter(requireContext(), it, "CartFragment")
            binding.cartRv.adapter = adapter

            binding.cartRv.layoutManager = LinearLayoutManager(requireContext())
        }



        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadCartItems()
    }

}