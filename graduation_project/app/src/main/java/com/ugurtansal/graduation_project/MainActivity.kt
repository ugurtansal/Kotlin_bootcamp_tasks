package com.ugurtansal.graduation_project

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.ugurtansal.graduation_project.databinding.ActivityMainBinding
import com.ugurtansal.graduation_project.ui.fragment.CartFragment
import com.ugurtansal.graduation_project.ui.fragment.FavoritesFragment
import com.ugurtansal.graduation_project.ui.fragment.HomeFragment
import com.ugurtansal.graduation_project.ui.fragment.ProfileFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)

        binding.bottomNavMainActivity.setOnItemSelectedListener {item->
            when (item.itemId) {
                R.id.bottom_nav_home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.bottom_nav_favorites -> {
                    loadFragment(FavoritesFragment())
                    true
                }
                R.id.bottom_nav_cart -> {
                    loadFragment(CartFragment())
                    true
                }
                R.id.bottom_nav_Profile -> {
                    loadFragment(ProfileFragment())
                    true
                }
                else -> false
            }
        }


        setContentView(binding.root)



    }

    fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, fragment)
            .commit()
    }
}