package com.example.myapplication

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.api.APIConfiguration
import com.example.myapplication.news.ListNewsUS
import com.example.myapplication.news.NewsUSItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FourActivityViewModel(private val app: Application): AndroidViewModel(app) {

    private val client = APIConfiguration.getAPIServices()

    var newsUSList = MutableLiveData<MutableList<NewsUSItem>>()

    fun getNewsUSList() {
        client.getNewsUSList().enqueue(object : Callback<ListNewsUS> {
            override fun onResponse(
                call: Call<ListNewsUS>,
                response: Response<ListNewsUS>
            ) {
                if (response.isSuccessful) {
                    newsUSList.value = (response.body()?.articles ?: emptyList()) as MutableList<NewsUSItem>?
                } else {
                    Toast.makeText(app, "Masalah pada Cloud", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ListNewsUS>, t: Throwable) {
                Toast.makeText(app, "Masalah pada Server", Toast.LENGTH_SHORT).show()
            }

        })
    }}