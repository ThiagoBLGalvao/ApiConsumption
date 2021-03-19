package com.example.apiconsumption.main

interface Contract {
    interface View {
        fun loadFragment()
    }

    interface Presenter<T : View> {
        var view: T?

        fun inti()
    }
}