package com.example.myapplication.news

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class ListNewsBBC(

    @field: SerializedName("status")
    val status: String,

    @field: SerializedName("totalResults")
    val totalResults: Int,

    @field: SerializedName("articles")
    val articles: List<NewsBBCItem>

) : Parcelable
