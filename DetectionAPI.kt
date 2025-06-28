package com.example.fakeaccountdetector

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface DetectionAPI {
    @POST("api/detect")
    fun detectFake(@Body profile: ProfileData): Call<ResultActivity>
}
