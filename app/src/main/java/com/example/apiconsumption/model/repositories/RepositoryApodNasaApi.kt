package com.example.apiconsumption.model.repositories

import com.example.apiconsumption.dtoClass.toModel
import com.example.apiconsumption.model.classes.Apod
import com.example.apiconsumption.model.apis.NasaApi
import io.reactivex.Observable

class RepositoryApodNasaApi(private val nasaApi: NasaApi): RepositoryNasa{

    override fun getApod(): Observable<Apod> {
        return nasaApi
            .getNasaContent("OCXR5OSXqPcSfW1JtKRtTzQssJkwfq64QbxB1jTz")
            .map { it.toModel() }
    }
}