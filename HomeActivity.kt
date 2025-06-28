package com.example.fakeaccountdetector

import android.os.Bundle
import android.widget.LinearLayout
import android.content.Intent
import android.widget.Button
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home) // XML filename should be activity_home.xml

        val btnDetectFake = findViewById<LinearLayout>(R.id.btnDetectFake)
        val btnReport = findViewById<LinearLayout>(R.id.btnReport)
        val btnCommunityFeedback = findViewById<Button>(R.id.btnCommunityFeedback)
        val btnLearn = findViewById<LinearLayout>(R.id.btnLearn)
        val btnProfile = findViewById<LinearLayout>(R.id.btnProfile)
        val btnHelpAbout = findViewById<LinearLayout>(R.id.btnHelpAbout)

        // 🔍 Fake Account Detection Screen
        btnDetectFake.setOnClickListener {
            startActivity(Intent(this, DetectPlatformActivity::class.java))
        }

        // 📝 My Reports
        btnReport.setOnClickListener {
            val intent = Intent(this, ReportActivity::class.java)
            startActivity(intent)
        }


        // 💬 Community Feedback
        btnCommunityFeedback.setOnClickListener {
            val intent = Intent(this, CommunityFeedbackActivity::class.java)
            startActivity(intent)
        }

        // 🎓 Learn to Identify Fakes
        btnLearn.setOnClickListener {
            val intent = Intent(this, LearnActivity::class.java)
            startActivity(intent)
        }

        // 👤profile
        btnProfile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }


        // ❓ Help/About
        btnHelpAbout.setOnClickListener {
            val intent = Intent(this, HelpActivity::class.java)
            startActivity(intent)
        }
    }
}
