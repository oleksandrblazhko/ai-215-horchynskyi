package com.example.safeco.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RegulatingSystem(
    val outdoorFactor: Int,
    val lightLvl: Int
) : Parcelable