package com.example.fakeaccountdetector.network

import com.example.fakeaccountdetector.data.model.DetectionRequest
import com.example.fakeaccountdetector.data.model.DetectionResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface FakeDetectionApi {
    @POST("detect")
    fun detectAccount(@Body request: DetectionRequest): Call<DetectionResponse>
}
