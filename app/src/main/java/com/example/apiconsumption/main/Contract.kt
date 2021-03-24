package com.example.apiconsumption.main

import com.example.apiconsumption.model.classes.Apod
import rx.Observable

interface Contract {
    interface View {
        fun loadNasaApodFragment(apod: Apod)

        fun loadLoadingScreen()
        
        fun hideLoadingScreen()
        
        fun loadErrorScreen(message: String?)
        
        fun checkPermissions()
    }

    interface Presenter<T : View> {
        var view: T?

        fun inti()

        fun onLoadFragment()
    }
}