package com.example.fakeaccountdetector

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.fakeaccountdetector.network.RetrofitClient
import com.example.fakeaccountdetector.network.FakeDetectionApi
import com.example.fakeaccountdetector.data.ProfileData
import com.example.fakeaccountdetector.data.DetectionResult

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlatformLoginActivity : AppCompatActivity() {

    private lateinit var platformName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_platform_login)

        // Get platform name from intent
        platformName = intent.getStringExtra("platform") ?: "Unknown"

        // Initialize views
        val platformTitle = findViewById<TextView>(R.id.platformTitle)
        val platformIcon = findViewById<ImageView>(R.id.platformIcon)
        val usernameInput = findViewById<EditText>(R.id.usernameInput)
        val analyzeButton = findViewById<Button>(R.id.analyzeButton)

        // Set platform title text
        platformTitle.text = "$platformName Login"

        // Set icon dynamically
        when (platformName) {
            "Instagram" -> platformIcon.setImageResource(R.drawable.ic_instagram)
            "Facebook" -> platformIcon.setImageResource(R.drawable.ic_facebook)
            "Twitter" -> platformIcon.setImageResource(R.drawable.ic_twitter)
            "LinkedIn" -> platformIcon.setImageResource(R.drawable.ic_linkedin)
            else -> platformIcon.setImageResource(R.drawable.ic_placeholder)
        }

        // Analyze button click
        analyzeButton.setOnClickListener {
            val username = usernameInput.text.toString().trim()
            if (username.isNotEmpty()) {
                sendProfileForDetection(username)
            } else {
                usernameInput.error = "Please enter a profile username or URL"
            }
        }
    }

    // ✅ This function should be OUTSIDE onCreate but INSIDE the class
    private fun sendProfileForDetection(username: String) {
        val profile = ProfileData(
            username = username,
            bio = "Click here 💰💰💰 #followme #promo",
            has_profile_pic = false,
            profile_pic_name = "default.jpg",
            first_post_after_days = 0,
            posts_with_same_text = 3,
            followers = 10,
            following = 1000,
            posts = 2,
            account_age_days = 3,
            mutual_followers = 1,
            verified = false,
            device_flagged_as_suspicious = true,
            same_device_multiple_accounts = true
        )

        RetrofitClient.api.detectAccount(profile).enqueue(object : Callback<DetectionResult> {
            override fun onResponse(
                call: Call<DetectionResult>,
                response: Response<DetectionResult>
            ) {
                if (response.isSuccessful) {
                    val result = response.body()
                    val intent = Intent(this@PlatformLoginActivity, ResultActivity::class.java)
                    intent.putExtra("platform", platformName)
                    intent.putExtra("username", username)
                    intent.putExtra("label", result?.label)
                    intent.putExtra("score", result?.score ?: 0)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@PlatformLoginActivity, "Server error", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<DetectionResult>, t: Throwable) {
                Toast.makeText(this@PlatformLoginActivity, "Network error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
