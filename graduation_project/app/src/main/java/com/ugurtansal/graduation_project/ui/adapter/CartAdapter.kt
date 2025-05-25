package com.ugurtansal.graduation_project.ui.adapter

import com.ugurtansal.graduation_project.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ugurtansal.graduation_project.data.entity.Dish
import com.ugurtansal.graduation_project.databinding.CardDesignBinding
import com.ugurtansal.graduation_project.databinding.CartCardDesignBinding
import com.ugurtansal.graduation_project.utils.showImg

class CartAdapter (val mContext: Context, val dishList:List<Dish>,val mode: String): RecyclerView.Adapter<CartAdapter.CartCardDesignHolder>(){

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
        t.foodName.text = dish.name
        t.priceTv.text = "${dish.price} ₺"
        showImg("ssss", t.foodImg)

        if (mode == "favorite") {
            t.plusIv.visibility = View.GONE
            t.minusIv.visibility = View.GONE
            t.pieceOfFood.visibility = View.GONE
            t.priceTv.visibility = View.GONE
            t.imageViewDelete.setImageResource(R.drawable.favorite_icn)
        }
    }

    override fun getItemCount(): Int {
       return dishList.size
    }


}

