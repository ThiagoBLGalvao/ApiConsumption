package com.example.apiconsumption.fragments.apodNasaFragment

import com.example.apiconsumption.enum.MediaTypeEnum
import com.example.apiconsumption.model.classes.Apod

class PresenterApodFragmentImpl<T: Contract.Fragment>(override var fragment: T?):
    Contract.Presenter<T> {
    override fun init(apodObject:Apod) {
        when(MediaTypeEnum.getMediaTypeEnum(apodObject.mediaType)){
            MediaTypeEnum.IMAGE -> fragment?.alterVisibilityImageview()

            MediaTypeEnum.VIDEO -> fragment?.alterVisibilityVideoView()
        }

        fragment?.loadFragment()
    }
}