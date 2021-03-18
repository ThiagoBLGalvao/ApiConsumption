package com.example.apiconsumption

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ApodDTO(
        val copyright: String,
        val date: String,
        val explanation: String,
        val mediaType: String,
        val title: String,
        val url: String
): Parcelable