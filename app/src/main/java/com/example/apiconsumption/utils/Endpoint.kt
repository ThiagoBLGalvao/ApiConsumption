package com.example.apiconsumption.utils

import com.example.apiconsumption.dtoClass.ApodDTO
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

interface Endpoint {
    @GET("apod?api_key={key}")
    fun getNasaContent(@Path("key") key: String): Observable<ApodDTO>
}