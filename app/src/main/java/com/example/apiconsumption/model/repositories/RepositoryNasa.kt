package com.example.apiconsumption.model.repositories

import com.example.apiconsumption.model.classes.Apod
import io.reactivex.Observable

interface RepositoryNasa {
    fun getApod(): Observable<Apod>
}