package com.example.fakeaccountdetector

import android.os.Bundle
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var ivProfile: ImageView
    private lateinit var tvName: TextView
    private lateinit var tvStatus: TextView
    private lateinit var tvFollowers: TextView
    private lateinit var tvBio: TextView
    private lateinit var tvHistory: TextView
    private lateinit var tvPicture: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var tvScoreLabel: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val ivProfile = findViewById<ImageView>(R.id.profileIcon)
        val tvName = findViewById<TextView>(R.id.tvUserName)
        val tvStatus = findViewById<TextView>(R.id.tvAccountStatus)
        val tvFollowers = findViewById<TextView>(R.id.tvFollowers)
        val tvBio = findViewById<TextView>(R.id.tvBio)
        val tvHistory = findViewById<TextView>(R.id.tvHistory)
        val tvPicture = findViewById<TextView>(R.id.tvPicture)
        val progressBar = findViewById<ProgressBar>(R.id.profileScoreBar)
        val tvScoreLabel = findViewById<TextView>(R.id.tvScoreLabel)


        // Set data (this would come from intent or backend in real app)
        tvName.text = "John Doe"
        tvStatus.text = "Account Status: Verified"
        tvFollowers.text = "1200 Followers"
        tvBio.text = "Verified Bio"
        tvHistory.text = "Active History"
        tvPicture.text = "High-Quality Picture"
        progressBar.progress = 80
        tvScoreLabel.text = "Profile Analysis Score"
    }
}
