package com.ugurtansal.graduation_project

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.ugurtansal.graduation_project.databinding.ActivityMainBinding
import com.ugurtansal.graduation_project.ui.fragment.CartFragment
import com.ugurtansal.graduation_project.ui.fragment.DetailFragment
import com.ugurtansal.graduation_project.ui.fragment.FavoritesFragment
import com.ugurtansal.graduation_project.ui.fragment.HomeFragment
import com.ugurtansal.graduation_project.ui.fragment.ProfileFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        binding.bottomNavMainActivity.setupWithNavController(navController)

        val fragmentsWithBottomNav = setOf(
            R.id.homeFragment,
            R.id.cartFragment,
            R.id.favoritesFragment,
            R.id.profileFragment
        )

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id in fragmentsWithBottomNav) {
                binding.bottomNavMainActivity.visibility = View.VISIBLE
            } else {
                binding.bottomNavMainActivity.visibility = View.GONE
            }
        }

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