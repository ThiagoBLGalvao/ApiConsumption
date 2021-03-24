package com.example.apiconsumption.model.repositories

import com.example.apiconsumption.model.classes.Apod
import rx.Observable

interface RepositoryNasa {
    fun getApod(): Observable<Apod>
}