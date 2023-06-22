package com.example.myapplication.news

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewsBBCItem(

    @field: SerializedName("author")
    val author: String,

    @field: SerializedName("title")
    val title: String,

    @field: SerializedName("description")
    val description: String,

    @field: SerializedName("urlToImage")
    val urlToImage: String
): Parcelable
