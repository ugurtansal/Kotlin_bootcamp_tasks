package com.ugurtansal.task_6

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

//        val navController = findNavController(R.id.fragmentContainerView)
//        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
//        bottomNav.setupWithNavController(navController)

    }
}