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
import com.ugurtansal.graduation_project.utils.addFavorite
import com.ugurtansal.graduation_project.utils.pass
import com.ugurtansal.graduation_project.utils.removeFavorite
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
        val dish=favorites.get(position)
        val t = holder.design

        t.foodName.text = dish.name
        t.priceTv.text = "${dish.price} ₺"
        showImg(dish.image, t.foodImg)


        t.cardViewRow.setOnClickListener {
            val dish= Dish(
                id = dish.id,
                name = dish.name,
                image = dish.image,
                price = dish.price.toString()
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
                addFavorite(it = View(mContext), dish.id)
            },
            onRemove = {
                removeFavorite(it= View(mContext), dish.id)
            }
        )
    }

    override fun getItemCount(): Int {
        return favorites.size
    }


}