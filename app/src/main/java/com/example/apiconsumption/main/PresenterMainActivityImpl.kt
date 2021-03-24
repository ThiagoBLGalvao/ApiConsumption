package com.example.apiconsumption.main

import com.example.apiconsumption.model.repositories.RepositoryNasa

class PresenterMainActivityImpl<T : Contract.View>(
    override var view: T?,
    private val repository: RepositoryNasa
) : Contract.Presenter<T> {

    override fun inti() {
        view?.checkPermissions()
    }

    override fun onLoadFragment() {
        repository.getApod()
            .doOnSubscribe {
                view?.loadLoadingScreen()
            }
            .subscribe(
                { view?.loadNasaApodFragment(it) },
                { view?.loadErrorScreen(it.message) }
            )
    }
}