package com.example.apiconsumption.fragments.apodNasaFragment

import com.example.apiconsumption.model.classes.Apod

interface FragmentContract {
    interface Fragment {
        fun loadFragment()

        fun alterVisibilityImageView()

        fun alterVisibilityVideoView()
    }

    interface Presenter<T : Fragment> {
        var fragment: T?

        fun init(apodObject: Apod)
    }
}