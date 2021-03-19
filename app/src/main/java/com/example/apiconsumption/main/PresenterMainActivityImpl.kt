package com.example.apiconsumption.main

class PresenterMainActivityImpl<T : Contract.View>(override var view: T?):Contract.Presenter<T> {
    override fun inti() {
        view?.loadActivity()
    }
}