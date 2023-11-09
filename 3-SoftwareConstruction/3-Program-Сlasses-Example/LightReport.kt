package com.example.safeco.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LightReport(
    val timePeriod: String,  // UTC time string
    val lightStats: Int
) : Parcelable