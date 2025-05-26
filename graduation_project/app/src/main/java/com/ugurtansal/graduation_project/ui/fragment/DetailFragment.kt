package com.ugurtansal.graduation_project.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ugurtansal.graduation_project.R
import com.ugurtansal.graduation_project.databinding.FragmentDetailBinding
import com.ugurtansal.graduation_project.utils.addFavorite
import com.ugurtansal.graduation_project.utils.addToCart
import com.ugurtansal.graduation_project.utils.removeFavorite
import com.ugurtansal.graduation_project.utils.setupCounter
import com.ugurtansal.graduation_project.utils.setupFavoriteToggle
import com.ugurtansal.graduation_project.utils.showImg
import kotlin.getValue


class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding= FragmentDetailBinding.inflate(inflater, container, false)

        val bundle: DetailFragmentArgs by navArgs()
        val dish=bundle.dish

        binding.priceTxt.text=dish.price.toString()
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

            binding.totalPriceTxt.text = "${newValue * dish.price} ₺"
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
            addToCart(it,dish.id) //extension function
        }

        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }


        return binding.root
    }


}