package com.example.fakeaccountdetector

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.fakeaccountdetector.data.model.DetectionResponse
import com.example.fakeaccountdetector.data.model.DetectionRequest
import com.example.fakeaccountdetector.network.FakeDetectionApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ResultActivity : AppCompatActivity() {

    private lateinit var tvScorePercent: TextView
    private lateinit var trustProgressBar: ProgressBar
    private lateinit var tvResultMessage: TextView
    private lateinit var indicator1: TextView
    private lateinit var indicator2: TextView
    private lateinit var indicator3: TextView
    private lateinit var indicator4: TextView
    private lateinit var resultTextView: TextView

    // change this to your IP if testing on real device
    private val BASE_URL = "http://192.168.50.94:3000/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        tvScorePercent = findViewById(R.id.tvScorePercent)
        trustProgressBar = findViewById(R.id.trustProgressBar)
        tvResultMessage = findViewById(R.id.tvResultMessage)
        indicator1 = findViewById(R.id.indicator1)
        indicator2 = findViewById(R.id.indicator2)
        indicator3 = findViewById(R.id.indicator3)
        indicator4 = findViewById(R.id.indicator4)
        resultTextView = findViewById(R.id.resultTextView)

        callFakeAccountAPI()
    }

    private fun callFakeAccountAPI() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(DetectionAPI::class.java)

        // You can customize this request from user input
        val request = DetectionRequest(
            username = "testuser",
            followers = 120,
            bio = "",
            accountAge = 2,
            screenshotQuality = "blurry"
        )

        api.detectAccount(request).enqueue(object : Callback<DetectionResponse> {
            override fun onResponse(call: Call<DetectionResponse>, response: Response<DetectionResponse>) {
                if (response.isSuccessful) {
                    val result = response.body()
                    if (result != null) {
                        tvScorePercent.text = "${result.trustScore}%"
                        trustProgressBar.progress = result.trustScore
                        tvResultMessage.text = result.message
                        resultTextView.text = result.message

                        // Show indicators
                        val indicators = result.indicators
                        indicator1.text = indicators.getOrNull(0) ?: "✅ Verified"
                        indicator2.text = indicators.getOrNull(1) ?: ""
                        indicator3.text = indicators.getOrNull(2) ?: ""
                        indicator4.text = indicators.getOrNull(3) ?: ""
                    }
                } else {
                    Toast.makeText(this@ResultActivity, "Error: ${response.code()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<DetectionResponse>, t: Throwable) {
                Toast.makeText(this@ResultActivity, "Failed: ${t.message}", Toast.LENGTH_LONG).show()
            }
        })
    }
}
