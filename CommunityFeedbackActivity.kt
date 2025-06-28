package com.example.fakeaccountdetector

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CommunityFeedbackActivity : AppCompatActivity() {

    private lateinit var tvCommunityResult: TextView
    private lateinit var tvVotesCount: TextView
    private lateinit var tvFeedbackNote: TextView
    private lateinit var btnLike: Button
    private lateinit var btnDislike: Button

    private var totalVotes = 198
    private var fakeVotes = 143
    private var realVotes = totalVotes - fakeVotes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community_feedback) // Use your actual layout file here

        // Initialize views
        tvCommunityResult = findViewById(R.id.tvCommunityResult)
        tvVotesCount = findViewById(R.id.tvVotesCount)
        tvFeedbackNote = findViewById(R.id.tvFeedbackNote)
        btnLike = findViewById(R.id.btnLike)
        btnDislike = findViewById(R.id.btnDislike)

        updateUI()

        // 👍 Looks Real
        btnLike.setOnClickListener {
            realVotes++
            totalVotes++
            Toast.makeText(this, "You voted: Looks Real 👍", Toast.LENGTH_SHORT).show()
            updateUI()
        }

        // 👎 Looks Fake
        btnDislike.setOnClickListener {
            fakeVotes++
            totalVotes++
            Toast.makeText(this, "You voted: Looks Fake 👎", Toast.LENGTH_SHORT).show()
            updateUI()
        }
    }

    private fun updateUI() {
        val fakePercentage = (fakeVotes * 100) / totalVotes
        tvCommunityResult.text = "$fakePercentage% users said: Looks Fake"
        tvVotesCount.text = "$totalVotes users voted"
    }
}
