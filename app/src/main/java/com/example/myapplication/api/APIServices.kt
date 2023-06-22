package com.example.myapplication.api

import com.example.myapplication.news.ListNewsBBC
import com.example.myapplication.news.ListNewsGerman
import com.example.myapplication.news.ListNewsUS
import retrofit2.Call
import retrofit2.http.GET


interface APIServices {

    @GET("https://newsapi.org/v2/top-headlines?sources=bbc-news&apiKey=7d9013eace434493874e38a81475101b")
    fun getNewsBBCList(): Call<ListNewsBBC>

    @GET("https://newsapi.org/v2/top-headlines?country=us&apiKey=7d9013eace434493874e38a81475101b")
    fun getNewsUSList(): Call<ListNewsUS>

    @GET("https://newsapi.org/v2/top-headlines?q=trump&apiKey=7d9013eace434493874e38a81475101b")
    fun getNewsGermanList(): Call<ListNewsGerman>
}
