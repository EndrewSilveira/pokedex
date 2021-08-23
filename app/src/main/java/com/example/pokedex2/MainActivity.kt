package com.example.pokedex2

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var isFirstBackPressed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Pokedexandroid)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount != 0) {
            super.onBackPressed()
        } else {
            if (isFirstBackPressed) {
                finish()
                super.onBackPressed()
            } else {
                isFirstBackPressed = true
                Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show()
                Handler().postDelayed({ isFirstBackPressed = false }, 1500)
            }
        }
    }
}