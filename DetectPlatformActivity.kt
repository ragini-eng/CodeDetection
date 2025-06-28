package com.example.fakeaccountdetector

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class DetectPlatformActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detect_platform)

        // Click listeners for each platform card
        findViewById<LinearLayout>(R.id.cardInstagram).setOnClickListener {
            openPlatformLogin("Instagram")
        }

        findViewById<LinearLayout>(R.id.cardFacebook).setOnClickListener {
            openPlatformLogin("Facebook")
        }

        findViewById<LinearLayout>(R.id.cardTwitter).setOnClickListener {
            openPlatformLogin("Twitter")
        }

        findViewById<LinearLayout>(R.id.cardLinkedIn).setOnClickListener {
            openPlatformLogin("LinkedIn")
        }
    }

    private fun openPlatformLogin(platformName: String) {
        val intent = Intent(this, PlatformLoginActivity::class.java)
        intent.putExtra("platform", platformName)
        startActivity(intent)
    }
}
