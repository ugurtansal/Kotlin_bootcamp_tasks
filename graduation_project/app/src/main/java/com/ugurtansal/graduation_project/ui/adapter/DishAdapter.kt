package com.ugurtansal.graduation_project.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ugurtansal.graduation_project.R
import com.ugurtansal.graduation_project.data.entity.Dish
import com.ugurtansal.graduation_project.databinding.CardDesignBinding
import com.ugurtansal.graduation_project.ui.fragment.HomeFragmentDirections
import com.ugurtansal.graduation_project.utils.addFavorite
import com.ugurtansal.graduation_project.utils.addToCart
import com.ugurtansal.graduation_project.utils.pass
import com.ugurtansal.graduation_project.utils.removeFavorite
import com.ugurtansal.graduation_project.utils.setupFavoriteToggle
import com.ugurtansal.graduation_project.utils.showImg

class DishAdapter(var mContext: Context, var dishList: List<Dish>) : RecyclerView.Adapter<DishAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(var design: CardDesignBinding) : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardDesignHolder {
        val design = CardDesignBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardDesignHolder(design)
    }

    override fun onBindViewHolder(
        holder: CardDesignHolder,
        position: Int
    ) {
        val dish=dishList.get(position)
        val t = holder.design

        t.favoriteBorderIv.setupFavoriteToggle( //extension function
            initialState = false,
            onAdd = {
                addFavorite(it = View(mContext), dish.id)
            },
            onRemove = {
                removeFavorite(it= View(mContext), dish.id)
            }
        )

        t.foodName.text = dish.name
        t.priceTxt.text = "${dish.price} ₺"
        showImg("ssss", t.foodImgIv)


        t.dishesCardView.setOnClickListener {

            val pass= HomeFragmentDirections.actionHomeFragmentToDetailFragment(dish = dish)

            Navigation.pass(it, pass)
        }

        t.constAddShopIcn.setOnClickListener {
            addToCart(it,dish.id)
        }
    }

    override fun getItemCount(): Int {
        return dishList.size
    }


}

