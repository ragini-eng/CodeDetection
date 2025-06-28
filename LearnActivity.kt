package com.example.fakeaccountdetector

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LearnActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn)

        val sectionFollowers = findViewById<LinearLayout>(R.id.sectionFollowers)
        val sectionBio = findViewById<LinearLayout>(R.id.sectionBio)
        val sectionActivity = findViewById<LinearLayout>(R.id.sectionActivity)
        val sectionProfile = findViewById<LinearLayout>(R.id.sectionProfile)

        sectionFollowers.setOnClickListener {
            Toast.makeText(this, "Checking followers for credibility tips", Toast.LENGTH_SHORT).show()
        }

        sectionBio.setOnClickListener {
            Toast.makeText(this, "Verifying bio content guidance", Toast.LENGTH_SHORT).show()
        }

        sectionActivity.setOnClickListener {
            Toast.makeText(this, "Activity history analysis coming soon", Toast.LENGTH_SHORT).show()
        }

        sectionProfile.setOnClickListener {
            Toast.makeText(this, "Profile picture quality detection coming soon", Toast.LENGTH_SHORT).show()
        }
    }
}
