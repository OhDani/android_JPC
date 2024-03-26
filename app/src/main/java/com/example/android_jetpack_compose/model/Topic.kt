package com.example.android_jetpack_compose.model
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val name: Int,
    val availableCourses: Int,
    @DrawableRes val imageRes: Int
)