package com.example.apiconsumption.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.apiconsumption.R
import com.example.apiconsumption.model.Apod
import com.example.apiconsumption.utils.Endpoint
import com.example.apiconsumption.utils.NasaNetworkUtil
import java.util.*

class MainActivity : AppCompatActivity(), Contract.View {
    private lateinit var apod: Apod

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_layout)

        val presenterImpl = PresenterMainActivityImpl(this@MainActivity)

        if(savedInstanceState == null)
            presenterImpl.inti()
    }

    private fun loadRetrofitService() {
        val retrofit = NasaNetworkUtil.getRetrofit("https://api.nasa.gov/planetary/")
        val endpoint = retrofit.create(Endpoint::class.java)

        endpoint
            .getNasaContent("OCXR5OSXqPcSfW1JtKRtTzQssJkwfq64QbxB1jTz")
            .subscribe {
                apod = Apod(it.title, it.explanation, it.copyright, it.mediaType, it.url)
            }
    }

    override fun loadFragment() {
        loadRetrofitService()


    }
}