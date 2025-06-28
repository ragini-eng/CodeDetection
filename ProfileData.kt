package com.example.fakeaccountdetector.data

data class ProfileData(
    val username: String,
    val bio: String,
    val has_profile_pic: Boolean,
    val profile_pic_name: String,
    val first_post_after_days: Int,
    val posts_with_same_text: Int,
    val followers: Int,
    val following: Int,
    val posts: Int,
    val account_age_days: Int,
    val mutual_followers: Int,
    val verified: Boolean,
    val device_flagged_as_suspicious: Boolean,
    val same_device_multiple_accounts: Boolean
)
