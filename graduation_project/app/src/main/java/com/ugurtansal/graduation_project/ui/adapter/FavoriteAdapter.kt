package com.ugurtansal.graduation_project.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ugurtansal.graduation_project.R
import com.ugurtansal.graduation_project.data.entity.Dish
import com.ugurtansal.graduation_project.data.entity.Favorites
import com.ugurtansal.graduation_project.databinding.CartCardDesignBinding
import com.ugurtansal.graduation_project.ui.fragment.FavoritesFragmentDirections
import com.ugurtansal.graduation_project.ui.viewModel.FavoritesViewModel
import com.ugurtansal.graduation_project.utils.pass
import com.ugurtansal.graduation_project.utils.setupFavoriteToggle
import com.ugurtansal.graduation_project.utils.showImg

class FavoriteAdapter (var mContext : Context, var favorites: List<Favorites>, var viewModel: FavoritesViewModel)
    : RecyclerView.Adapter<FavoriteAdapter.CartCardDesignHolder>(){
    inner class CartCardDesignHolder(var design: CartCardDesignBinding): RecyclerView.ViewHolder(design.root)


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
        val favorite=favorites.get(position)
        val t = holder.design

        t.foodName.text = favorite.name
        t.priceTv.text = "${favorite.price} ₺"
        showImg(favorite.image, t.foodImg)


        t.cardViewRow.setOnClickListener {
            val dish= Dish(
                id = favorite.id,
                name = favorite.name,
                image = favorite.image,
                price = favorite.price.toString()
            )
            val pass= FavoritesFragmentDirections.actionFavoritesFragmentToDetailFragment(dish = dish)
            Navigation.pass(it, pass)
        }
        t.btnAdd.visibility = View.GONE
        t.btnMinus.visibility = View.GONE
        t.pieceOfFood.visibility = View.GONE
        t.priceTv.visibility = View.GONE
        t.deleteIv.setImageResource(R.drawable.favorite_icn)

        t.deleteIv.setupFavoriteToggle(
            initialState = true,
            onAdd = {
               viewModel.addToFavorites(dish= Dish(
                    id = favorite.id,
                    name = favorite.name,
                    image = favorite.image,
                    price = favorite.price.toString()
                ))
            },
            onRemove = {
                viewModel.delete(dishName = favorite.name)
            }
        )
    }

    override fun getItemCount(): Int {
        return favorites.size
    }


}