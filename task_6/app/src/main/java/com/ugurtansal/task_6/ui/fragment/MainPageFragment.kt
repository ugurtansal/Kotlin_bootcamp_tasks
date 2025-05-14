package com.ugurtansal.task_6.ui.fragment

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ugurtansal.task_6.R
import com.ugurtansal.task_6.data.Category
import com.ugurtansal.task_6.databinding.FragmentMainPageBinding
import com.ugurtansal.task_6.ui.adapter.CategoryAdapter


class MainPageFragment : Fragment() {

    private lateinit var binding: FragmentMainPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding= FragmentMainPageBinding.inflate(inflater, container, false)

        var myBtn=binding.button;
        val drawable= GradientDrawable().apply {
            shape= GradientDrawable.RECTANGLE
            cornerRadii= floatArrayOf(
                0f,0f, // top left
                70f,70f, // top right
                70f,70f, // bottom right
                0f,0f // bottom left
            )
            setColor(Color.parseColor("#FDFDFD"))

        }
        myBtn.backgroundTintList = null // Ripple rengini sıfırlar

        myBtn.background=drawable

        binding.categoriesRv.layoutManager=
            StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL)

        val categoryList=ArrayList<Category>();
        val c1=Category(1,"atistirmalik","atistirmalik_img")
        val c2=Category(2,"dondurma","dondurma_img")
        val c3=Category(3,"et&Tavuk","et_img")
        val c5=Category(5,"ev_bakim","ev_bakim_img")
        val c6=Category(6,"ev_yasam","ev_yasam_img")
        val c7=Category(7,"firin","firin_img")
        val c8=Category(8,"fit","fit_img")
        val c9=Category(9,"hayvan","hayvan_img")
        val c10=Category(10,"icecek","icecek_img")
        val c11=Category(11,"kahvaltilik","et_img")
        val c12=Category(12,"kisisel_bakim","kisisel_bakim_img")
        val c13=Category(13,"meyve","meyve_img")
        val c14=Category(14,"sut","sut_img")
        val c16=Category(16,"temel_gida","temel_gida_img")
        val c17=Category(17,"yiyecek","yiyecek_img")
        val c18=Category(18,"bebek","bebek_img")
        val c19=Category(19,"cinsel","cinsel_img")

        categoryList.add(c1)
        categoryList.add(c2)
        categoryList.add(c3)
        categoryList.add(c5)
        categoryList.add(c6)
        categoryList.add(c7)
        categoryList.add(c8)
        categoryList.add(c9)
        categoryList.add(c10)
        categoryList.add(c11)
        categoryList.add(c12)
        categoryList.add(c13)
        categoryList.add(c14)
        categoryList.add(c16)
        categoryList.add(c17)
        categoryList.add(c18)
        categoryList.add(c19)

        val adapter= CategoryAdapter(requireContext(),categoryList)

        binding.categoriesRv.adapter=adapter


        return binding.root
    }


}