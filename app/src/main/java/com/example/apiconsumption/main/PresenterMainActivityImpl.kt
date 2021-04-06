package com.example.apiconsumption.main

import android.annotation.SuppressLint
import com.example.apiconsumption.model.repositories.RepositoryNasa
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PresenterMainActivityImpl<T : Contract.View>(
    override var view: T?,
    private val repository: RepositoryNasa
) : Contract.Presenter<T> {

    override fun inti() {
        view?.checkPermissions()
    }

    @SuppressLint("CheckResult")
    override fun onLoadFragment() {
        repository.getApod()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                view?.loadLoadingScreen()
            }
            .subscribe(
                {
                    view?.loadNasaApodFragment(it)
                },
                {
                    view?.loadErrorScreen(it.message)
                }
            )
    }
}