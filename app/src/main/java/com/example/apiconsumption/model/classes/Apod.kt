package com.example.apiconsumption.model.classes

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Apod(
    val title:String,
    val description: String,
    val copyright: String?,
    val mediaType: String,
    val url: String
):Parcelable