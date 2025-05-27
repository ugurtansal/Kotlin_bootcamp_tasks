package com.ugurtansal.graduation_project.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ugurtansal.graduation_project.R
import com.ugurtansal.graduation_project.databinding.FragmentDetailBinding
import com.ugurtansal.graduation_project.ui.viewModel.DetailViewModel
import com.ugurtansal.graduation_project.utils.addFavorite
import com.ugurtansal.graduation_project.utils.addToCart
import com.ugurtansal.graduation_project.utils.removeFavorite
import com.ugurtansal.graduation_project.utils.setupCounter
import com.ugurtansal.graduation_project.utils.setupFavoriteToggle
import com.ugurtansal.graduation_project.utils.showImg
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private lateinit var viewModel: DetailViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: DetailViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding= FragmentDetailBinding.inflate(inflater, container, false)

        val bundle: DetailFragmentArgs by navArgs()
        val dish=bundle.dish

        binding.priceTxt.text=dish.price
        binding.foodNameTxt.text=dish.name
        binding.totalPriceTxt.text=dish.price.toString()
        showImg("ssss", binding.foodIv)

//        binding.closeIv.setOnClickListener {
//            findNavController().popBackStack()
//        }


        setupCounter( //extension function
            minusBtn = binding.btnMinus,
            plusBtn = binding.btnAdd,
            countTextView = binding.countTxt,
            initialValue = 1,
            min = 1,
            max = 20
        ) { newValue ->

            binding.totalPriceTxt.text = "${newValue * (dish.price.toInt())} ₺"
            binding.countTxt.text = newValue.toString()
        }

        binding.favoriteIv.setupFavoriteToggle( //extension function
            initialState = false,
            onAdd = {
                view?.let { addFavorite(it, dish.id) }
            },
            onRemove = {
                view?.let { removeFavorite(it, dish.id) }
            }
        )

        binding.btnAddCart.setOnClickListener {
           viewModel.addToCart(dish.name,dish.image,dish.price.toInt(),binding.countTxt.text.toString().toInt())
//            view?.let { addToCart(it, dish.id) }
//            findNavController().popBackStack()
        }

        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }


        return binding.root
    }





}