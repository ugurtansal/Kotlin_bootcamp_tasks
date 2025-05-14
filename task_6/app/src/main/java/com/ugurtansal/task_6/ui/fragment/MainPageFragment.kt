package com.ugurtansal.task_6.ui.fragment

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ugurtansal.task_6.R
import com.ugurtansal.task_6.databinding.FragmentMainPageBinding


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

        return binding.root
    }


}