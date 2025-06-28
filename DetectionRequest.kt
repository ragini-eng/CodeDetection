package com.example.fakeaccountdetector.data.model


data class DetectionRequest(
    val username: String,
    val followers: Int,
    val bio: String,
    val accountAge: Int,
    val screenshotQuality: String
)