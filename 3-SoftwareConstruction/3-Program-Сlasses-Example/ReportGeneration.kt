package com.example.safeco.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ReportGeneration(
    val status: Boolean
) : Parcelable