package com.example.apiconsumption.fragments.apodNasaFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.VideoView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.apiconsumption.R
import com.example.apiconsumption.model.classes.Apod

class ApodFragment : Fragment(), Contract.Fragment {
    lateinit var apodImageView : ImageView
    lateinit var apodVideoView: VideoView
    lateinit var titleTextView: TextView
    lateinit var description: TextView
    lateinit var copyrightView: TextView

    companion object{
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

        return view
    }

    private fun getApodObject() = arguments?.get(APODOBJECT)

    override fun loadFragment() {

    }

    override fun alterVisibilityImageview() {
        TODO("Not yet implemented")
    }

    override fun alterVisibilityVideoView() {
        TODO("Not yet implemented")
    }


}