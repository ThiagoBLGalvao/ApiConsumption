package com.example.apiconsumption.dtoClass

import android.os.Parcelable
import com.example.apiconsumption.model.classes.Apod
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

fun ApodDTO.toModel(): Apod = Apod(title, explanation, copyright, mediaType, url)