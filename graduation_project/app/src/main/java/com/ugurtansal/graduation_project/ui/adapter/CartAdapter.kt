package com.ugurtansal.graduation_project.ui.adapter

import com.ugurtansal.graduation_project.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ugurtansal.graduation_project.data.entity.Cart
import com.ugurtansal.graduation_project.data.entity.Dish
import com.ugurtansal.graduation_project.databinding.CardDesignBinding
import com.ugurtansal.graduation_project.databinding.CartCardDesignBinding
import com.ugurtansal.graduation_project.ui.fragment.CartFragmentDirections
import com.ugurtansal.graduation_project.ui.fragment.FavoritesFragmentDirections
import com.ugurtansal.graduation_project.ui.fragment.HomeFragmentDirections
import com.ugurtansal.graduation_project.utils.addFavorite
import com.ugurtansal.graduation_project.utils.pass
import com.ugurtansal.graduation_project.utils.removeFavorite
import com.ugurtansal.graduation_project.utils.setupCounter
import com.ugurtansal.graduation_project.utils.setupFavoriteToggle
import com.ugurtansal.graduation_project.utils.showImg

class CartAdapter (val mContext: Context, val dishList:List<Cart>, val mode: String): RecyclerView.Adapter<CartAdapter.CartCardDesignHolder>(){

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
        val dish=dishList.get(position)
        val t = holder.design

        t.foodName.text = dish.dishName
        t.priceTv.text = "${dish.dishPrice} ₺"
        showImg(dish.dishImage, t.foodImg)

        if (mode == "favorite") {
            val dish= Dish(
                id = dish.cartDishId,
                name = dish.dishName,
                price = dish.dishPrice,
                image = dish.dishImage
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
            t.cardViewRow.setOnClickListener {
                val dish= Dish(
                    id = dish.cartDishId,
                    name = dish.dishName,
                    price = dish.dishPrice,
                    image = dish.dishImage
                )
                val pass= CartFragmentDirections.actionCartFragmentToDetailFragment(dish = dish)
                Navigation.pass(it, pass)
            }
            setupCounter( //extension function
                minusBtn = t.btnMinus,
                plusBtn = t.btnAdd,
                countTextView = t.pieceOfFood,
                initialValue = 1,
                min = 1,
                max = 20
            ) { newValue ->

                t.priceTv.text = "${newValue * (dish.dishPrice.toInt())} ₺"
               t.pieceOfFood.text = newValue.toString()
            }

            t.deleteIv.setOnClickListener {
                removeFavorite(it= View(mContext), dish.cartDishId)
            }
        }
    }

    override fun getItemCount(): Int {
       return dishList.size
    }


}

