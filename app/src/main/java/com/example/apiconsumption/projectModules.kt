package com.example.apiconsumption

import com.example.apiconsumption.fragments.apodNasaFragment.FragmentContract
import com.example.apiconsumption.fragments.apodNasaFragment.PresenterApodFragmentImpl
import com.example.apiconsumption.main.Contract
import com.example.apiconsumption.main.PresenterMainActivityImpl
import com.example.apiconsumption.model.apis.NasaApi
import com.example.apiconsumption.model.repositories.RepositoryApodNasaApi
import com.example.apiconsumption.model.repositories.RepositoryNasa
import com.example.apiconsumption.model.retrofit.NasaNetworkUtil
import org.koin.dsl.module

val projectModules = module {
    single<RepositoryNasa> {
        RepositoryApodNasaApi(
            NasaNetworkUtil.getRetrofit("https://api.nasa.gov/planetary/").create(
                NasaApi::class.java
            )
        )
    }

    factory<Contract.Presenter<Contract.View>> { (view: Contract.View) ->
        PresenterMainActivityImpl(
            view = view,
            repository = get()
        )
    }

    factory<FragmentContract.Presenter<FragmentContract.Fragment>> { (fragment: FragmentContract.Fragment) ->
        PresenterApodFragmentImpl(fragment)
    }
}