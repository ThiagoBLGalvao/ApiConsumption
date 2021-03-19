package com.example.apiconsumption.enum

enum class MediaTypeEnum(val type: String) {
    IMAGE("image"),
    VIDEO("video"),
    UNKNOWN("");

    companion object{
        fun getMediaTypeEnum(type: String): MediaTypeEnum =
            values().find {
                it.type == type
            } ?: UNKNOWN
    }
}