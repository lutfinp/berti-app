package com.example.myapplication.api

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIConfiguration {
    companion object{
        fun getAPIServices(): APIServices{

            //Membuat client
            val client = OkHttpClient.Builder().build()

            //Membuat instansi Retrofit
            val retrofit = Retrofit.Builder()
                .baseUrl("https://newsapi.org")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

            //Membuat objek APIServices menggunakan Retrofit
            return retrofit.create(APIServices::class.java)
        }
    }
}