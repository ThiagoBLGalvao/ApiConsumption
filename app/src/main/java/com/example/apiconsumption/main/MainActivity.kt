package com.example.apiconsumption.main

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.apiconsumption.R
import com.example.apiconsumption.fragments.apodNasaFragment.ApodFragment
import com.example.apiconsumption.model.classes.Apod
import com.example.apiconsumption.model.apis.NasaApi
import com.example.apiconsumption.model.repositories.RepositoryApodNasaApi
import com.example.apiconsumption.model.retrofit.NasaNetworkUtil
import java.util.*

class MainActivity : AppCompatActivity(), Contract.View {
    private lateinit var presenterImpl : PresenterMainActivityImpl<MainActivity>
    private lateinit var loadingScreen: ConstraintLayout
    private lateinit var errorScreen: ConstraintLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_layout)

        val endpoint = NasaNetworkUtil.getRetrofit("https://api.nasa.gov/planetary/").create(NasaApi::class.java)

        val repository = RepositoryApodNasaApi(endpoint)

        loadingScreen = findViewById(R.id.loading_screen)
        errorScreen = findViewById(R.id.error_screen)

        presenterImpl = PresenterMainActivityImpl(this@MainActivity, repository)

        if(savedInstanceState == null)
            presenterImpl.inti()
    }

    override fun loadNasaApodFragment(apod: Apod) {
        val fragment = ApodFragment.newInstance(apod)

        hideLoadingScreen()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container,fragment, "apod_fragment")
            .commit()
    }

    override fun loadLoadingScreen() {
        loadingScreen.visibility = View.VISIBLE
    }

    override fun hideLoadingScreen() {
        loadingScreen.visibility = View.GONE
    }

    override fun loadErrorScreen(message: String?) {
        errorScreen.visibility = View.VISIBLE
        findViewById<TextView>(R.id.error_text).text = message ?: getString(R.string.unknown_error)
    }

    override fun checkPermissions() {
        when (PackageManager.PERMISSION_GRANTED) {
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.INTERNET
            ) -> presenterImpl.onLoadFragment()

            else -> ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.INTERNET), 100
            )
        }
    }
}