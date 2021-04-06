package com.example.apiconsumption.fragments.apodNasaFragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.apiconsumption.R
import com.example.apiconsumption.model.classes.Apod
import com.squareup.picasso.Picasso
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class ApodFragment : Fragment(), FragmentContract.Fragment {
    private val presenterFragment by inject<FragmentContract.Presenter<FragmentContract.Fragment>> { parametersOf(this) }
    private lateinit var apodImageView: ImageView
    private lateinit var apodVideoView: VideoView
    private lateinit var titleTextView: TextView
    private lateinit var description: TextView
    private lateinit var copyrightView: TextView
    private lateinit var mediaController: MediaController
    var apodObject: Apod? = null

    companion object {
        const val APODOBJECT = "apod_object"

        fun newInstance(apod: Apod) = ApodFragment().apply {
            arguments = bundleOf(
                APODOBJECT to apod
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_nasa_item, container, false)

        apodImageView = view.findViewById(R.id.image_nasa)
        apodVideoView = view.findViewById(R.id.video_nasa)
        titleTextView = view.findViewById(R.id.title_nasa_content)
        description = view.findViewById(R.id.explanation_nasa_content)
        copyrightView = view.findViewById(R.id.copyright_nasa_content)
        apodObject = getObjectDeserialized()
        mediaController = MediaController(activity as Context)

        apodObject?.let {
            presenterFragment.init(it)
        }

        return view
    }

    private fun getObjectDeserialized() = arguments?.getParcelable<Apod>(APODOBJECT)

    override fun loadFragment() {
        with(apodObject) {
            titleTextView.text = this?.title ?: "Unknown"
            description.text = this?.description ?: "Unknown"
            copyrightView.text = this?.copyright ?: "Unknown"
        }
    }

    override fun alterVisibilityImageView() {
        apodImageView.visibility = View.VISIBLE
        Picasso.get().load(Uri.parse(apodObject?.url)).into(apodImageView)
    }

    override fun alterVisibilityVideoView() {
        apodVideoView.apply {
            visibility = View.VISIBLE
            setVideoURI(Uri.parse(apodObject?.url))
            setMediaController(mediaController)
            mediaController.setAnchorView(apodVideoView)
        }
    }
}