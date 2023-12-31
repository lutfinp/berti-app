package com.example.myapplication

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.api.APIConfiguration
import com.example.myapplication.news.ListNewsGerman
import com.example.myapplication.news.NewsGermanItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SecondActivityViewModel(private val app: Application): AndroidViewModel(app) {

    private val client = APIConfiguration.getAPIServices()

    var newsGermanList = MutableLiveData<MutableList<NewsGermanItem>>()

    fun getNewsGermanList() {
        client.getNewsGermanList().enqueue(object : Callback<ListNewsGerman> {
            override fun onResponse(
                call: Call<ListNewsGerman>,
                response: Response<ListNewsGerman>
            ) {
                if (response.isSuccessful) {
                    newsGermanList.value = (response.body()?.articles ?: emptyList()) as MutableList<NewsGermanItem>?
                } else {
                    Toast.makeText(app, "Masalah pada Cloud", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ListNewsGerman>, t: Throwable) {
                Toast.makeText(app, "Masalah pada Server", Toast.LENGTH_SHORT).show()
            }

        })
    }}