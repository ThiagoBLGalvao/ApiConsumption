package com.example.apiconsumption.model.apis

import com.example.apiconsumption.dtoClass.ApodDTO
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface NasaApi {
    @GET("apod")
    fun getNasaContent(@Query("api_key") key: String): Observable<ApodDTO>
}