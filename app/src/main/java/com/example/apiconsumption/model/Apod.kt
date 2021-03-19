package com.example.apiconsumption.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Apod(
    val title:String,
    val description: String,
    val copyright: String,
    val mediaType: String,
    val url: String
):Parcelable