package com.example.apiconsumption.fragments.apodNasaFragment

import com.example.apiconsumption.model.classes.Apod

interface Contract {
    interface Fragment {
        fun loadFragment()

        fun alterVisibilityImageview()

        fun alterVisibilityVideoView()
    }

    interface Presenter<T : Fragment> {
        var fragment: T?

        fun init(apodObject: Apod)
    }
}