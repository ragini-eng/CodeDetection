package com.example.fakeaccountdetector.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL =  "https://FakeDetectorBackend-username.repl.co/detect"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: FakeDetectionApi = retrofit.create(FakeDetectionApi::class.java)
}
