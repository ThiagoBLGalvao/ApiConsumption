package com.example.apiconsumption.dtoClass

import android.os.Parcelable
import com.example.apiconsumption.model.classes.Apod
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ApodDTO(
        @SerializedName("copyright")
        val copyright: String,
        @SerializedName("date")
        val date: String,
        @SerializedName("explanation")
        val explanation: String,
        @SerializedName("media_type")
        val mediaType: String,
        @SerializedName("title")
        val title: String,
        val url: String
): Parcelable

fun ApodDTO.toModel(): Apod = Apod(title, explanation, copyright, mediaType, url)