package com.example.apiconsumption.fragments.apodNasaFragment

import com.example.apiconsumption.enum.MediaTypeEnum
import com.example.apiconsumption.model.classes.Apod

class PresenterApodFragmentImpl<T: FragmentContract.Fragment>(override var fragment: T?):
    FragmentContract.Presenter<T> {
    override fun init(apodObject:Apod) {
        when(MediaTypeEnum.getMediaTypeEnum(apodObject.mediaType)){
            MediaTypeEnum.IMAGE -> fragment?.alterVisibilityImageView()

            MediaTypeEnum.VIDEO -> fragment?.alterVisibilityVideoView()
        }

        fragment?.loadFragment()
    }
}