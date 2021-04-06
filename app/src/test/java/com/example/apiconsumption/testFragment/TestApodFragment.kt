package com.example.apiconsumption.testFragment

import com.example.apiconsumption.fragments.apodNasaFragment.FragmentContract
import com.example.apiconsumption.fragments.apodNasaFragment.PresenterApodFragmentImpl
import com.example.apiconsumption.model.classes.Apod
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class TestApodFragment {
    private val fragment: FragmentContract.Fragment = mockk(relaxed = true)
    private lateinit var presenter: FragmentContract.Presenter<FragmentContract.Fragment>
    private val apodObjectImage = Apod("test","test",null,"image","test")
    private val apodObjectVideo = Apod("test","test",null,"video","test")

    @Before
    fun setUp(){
        presenter = PresenterApodFragmentImpl(fragment)
    }

    @Test
    fun `given an object that have media type image when init triggered then verify alterVisibilityImageView`(){

        presenter.init(apodObjectImage)

        verify {
            fragment.alterVisibilityImageView()

            fragment.loadFragment()
        }
    }
    @Test
    fun `given an object that have media type video when init triggered then verify alterVisibilityVideoView`(){

        presenter.init(apodObjectVideo)

        verify {
            fragment.alterVisibilityVideoView()

            fragment.loadFragment()
        }
    }
}