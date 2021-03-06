package com.example.apiconsumption.model.retrofit

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NasaNetworkUtil {
    companion object {
        val gson = GsonBuilder().setLenient().create()

        fun getRetrofit(path: String): Retrofit{
            return Retrofit.Builder()
                .baseUrl(path)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }
    }
}