package com.example.apiconsumption.testsMain

import com.example.apiconsumption.main.Contract
import com.example.apiconsumption.main.PresenterMainActivityImpl
import com.example.apiconsumption.model.classes.Apod
import com.example.apiconsumption.model.repositories.RepositoryNasa
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import java.util.concurrent.Callable


class TestsMainActivity {
    private val view: Contract.View = mockk(relaxed = true)

    private val repository: RepositoryNasa = mockk(relaxed = true)

    private lateinit var presenterImpl: Contract.Presenter<Contract.View>

    companion object {
        const val ERROR_MESSAGE = "not found object"

        fun getObservableReturn() = Observable.just(mockk<Apod>())
    }

    @Before
    fun setUp() {
        presenterImpl = PresenterMainActivityImpl(view, repository)

        RxAndroidPlugins.setInitMainThreadSchedulerHandler { scheduler: Callable<Scheduler?>? -> Schedulers.trampoline() }

    }

    @Test
    fun `when init triggered then verify checkPermissions`() {
        presenterImpl.inti()

        verify { view.checkPermissions() }
    }

    @Test
    fun `when onLoadFragment triggered then verify success way`() {
        every { repository.getApod() } returns getObservableReturn()

        presenterImpl.onLoadFragment()

        verify {
            view.loadLoadingScreen()
            view.loadNasaApodFragment(any())
        }
    }

    @Test
    fun `when onLoad triggered and getApod returns null then verify error way`(){
        every{repository.getApod()} returns Observable.error(Exception("Object not returned"))

        presenterImpl.onLoadFragment()

        verify {
            view.loadLoadingScreen()
            view.loadErrorScreen(any())
        }
    }
}