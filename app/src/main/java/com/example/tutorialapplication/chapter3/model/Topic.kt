package com.example.tutorialapplication.chapter3.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic (
    @StringRes val stringResourceId: Int,
    val relatedCoursesCount: Int,
    @DrawableRes val imageResourceId: Int
)
