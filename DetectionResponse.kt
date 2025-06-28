package com.example.fakeaccountdetector.data.model

data class DetectionResponse(
    val trustScore: Int,
    val message: String,
    val indicators: List<String>
)