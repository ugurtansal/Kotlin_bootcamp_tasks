package com.ugurtansal.graduation_project.ui.adapter

import com.ugurtansal.graduation_project.R
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ugurtansal.graduation_project.data.entity.Cart
import com.ugurtansal.graduation_project.data.entity.Dish
import com.ugurtansal.graduation_project.databinding.CartCardDesignBinding
import com.ugurtansal.graduation_project.retrofit.CartDao
import com.ugurtansal.graduation_project.ui.fragment.CartFragmentDirections
import com.ugurtansal.graduation_project.ui.fragment.FavoritesFragmentDirections
import com.ugurtansal.graduation_project.ui.viewModel.CartViewModel
import com.ugurtansal.graduation_project.utils.addFavorite
import com.ugurtansal.graduation_project.utils.pass
import com.ugurtansal.graduation_project.utils.removeFavorite
import com.ugurtansal.graduation_project.utils.setupCounter
import com.ugurtansal.graduation_project.utils.setupFavoriteToggle
import com.ugurtansal.graduation_project.utils.showImg

class CartAdapter (val mContext: Context, val dishList:List<Cart>, val mode: String,
                   private val onRemoveFromCart: ((Int) -> Unit)? = null, // cartDishId verilir
                   private val onFavoriteAdd: ((Int) -> Unit)? = null, // dishId verilir
                   private val onFavoriteRemove: ((Int) -> Unit)? = null // dishId verilir
                ): RecyclerView.Adapter<CartAdapter.CartCardDesignHolder>(){

    inner class CartCardDesignHolder(var design: CartCardDesignBinding) : RecyclerView.ViewHolder(design.root)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CartCardDesignHolder {
        val design = CartCardDesignBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CartCardDesignHolder(design)
    }

    override fun onBindViewHolder(
        holder: CartCardDesignHolder,
        position: Int
    ) {
        val cartDish=dishList.get(position)
        val t = holder.design

        t.foodName.text = cartDish.dishName
        t.priceTv.text = "${cartDish.dishPrice} ₺"
        showImg(cartDish.dishImage, t.foodImg)

        if (mode == "favorite") {
            val dish= Dish(
                id = cartDish.cartDishId,
                name = cartDish.dishName,
                price = cartDish.dishPrice,
                image = cartDish.dishImage
            )
            t.cardViewRow.setOnClickListener {
                val pass= FavoritesFragmentDirections.actionFavoritesFragmentToDetailFragment(dish = dish)
                Navigation.pass(it, pass)
            }
            t.btnAdd.visibility = View.GONE
            t.btnMinus.visibility = View.GONE
            t.pieceOfFood.visibility = View.GONE
            t.priceTv.visibility = View.GONE
            t.deleteIv.setImageResource(R.drawable.favorite_icn)

            t.deleteIv.setupFavoriteToggle( //extension function
                initialState = true,
                onAdd = {
                    addFavorite(it = View(mContext), dish.id)
                },
                onRemove = {
                    removeFavorite(it= View(mContext), dish.id)
                }
            )

        }
        else{
            t.pieceOfFood.text=cartDish.dishQuantity
            t.priceTv.text="${(cartDish.dishQuantity.toInt())*(cartDish.dishPrice.toInt())} ₺"
            t.deleteIv.setOnClickListener {
                onRemoveFromCart?.invoke(cartDish.cartDishId)
            }

            t.cardViewRow.setOnClickListener {
                val dish= Dish(
                    id = cartDish.cartDishId,
                    name = cartDish.dishName,
                    price = cartDish.dishPrice,
                    image = cartDish.dishImage
                )

                val pass= CartFragmentDirections.actionCartFragmentToDetailFragment(dish = dish)
                Navigation.pass(it, pass)
            }
            setupCounter( //extension function
                minusBtn = t.btnMinus,
                plusBtn = t.btnAdd,
                countTextView = t.pieceOfFood,
                initialValue = cartDish.dishQuantity.toInt(),
                min = 1,
                max = 20
            ) { newValue ->

                t.priceTv.text = "${newValue * (cartDish.dishPrice.toInt())} ₺"
               t.pieceOfFood.text = newValue.toString()
            }

        }
    }

    override fun getItemCount(): Int {
       return dishList.size
    }


}

