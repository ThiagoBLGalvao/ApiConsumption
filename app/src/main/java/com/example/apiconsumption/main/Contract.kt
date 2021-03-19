package com.example.apiconsumption.main

interface Contract {
    interface View {
        fun loadActivity()
    }

    interface Presenter<T : View> {
        var view: T?

        fun inti()
    }
}