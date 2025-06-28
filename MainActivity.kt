// File: MainActivity.kt
package com.example.fakeaccountdetector
import android.util.Log

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "onCreate called")
        // Show splash screen layout
        setContentView(R.layout.activity_main)  // was: activity_splash


        // After 2 seconds, navigate to LoginActivity
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // so user can't go back to splash screen
        }, 2000) // 2000ms = 2 seconds
    }
}
