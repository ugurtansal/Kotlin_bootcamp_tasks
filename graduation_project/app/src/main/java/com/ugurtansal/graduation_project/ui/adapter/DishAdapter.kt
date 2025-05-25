package com.ugurtansal.graduation_project.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ugurtansal.graduation_project.data.entity.Dish
import com.ugurtansal.graduation_project.databinding.CardDesignBinding

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
        t.foodName.text = dish.name
        t.priceTxt.text = "${dish.price} ₺"
        showImg("ssss", t.foodImgIv)
    }

    override fun getItemCount(): Int {
        return dishList.size
    }


}

fun showImg(resimAdi:String,imageView: ImageView){
    val url="http://kasimadalan.pe.hu/yemekler/resimler/ayran.png" // Example URL, replace with actual image URL
    Glide.with(imageView).load(url).override(450,450).into(imageView)
}