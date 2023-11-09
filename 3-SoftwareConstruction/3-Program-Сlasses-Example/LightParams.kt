package com.example.safeco.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LightParams(
    val checkTime: Int,
    val minBrightness: Float
) : Parcelable