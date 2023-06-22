package com.example.myapplication

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.api.APIConfiguration
import com.example.myapplication.news.ListNewsBBC
import com.example.myapplication.news.NewsBBCItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ThirdActivityViewModel(private val app: Application): AndroidViewModel(app) {

    private val client = APIConfiguration.getAPIServices()

    var newsBBCList = MutableLiveData<MutableList<NewsBBCItem>>()

    fun getNewsBBCList() {
        client.getNewsBBCList().enqueue(object : Callback<ListNewsBBC> {
            override fun onResponse(
                call: Call<ListNewsBBC>,
                response: Response<ListNewsBBC>
            ) {
                if (response.isSuccessful) {
                    newsBBCList.value = (response.body()?.articles ?: emptyList()) as MutableList<NewsBBCItem>?
                } else {
                    Toast.makeText(app, "Masalah pada Cloud", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ListNewsBBC>, t: Throwable) {
                Toast.makeText(app, "Masalah pada Server", Toast.LENGTH_SHORT).show()
            }

        })
    }}
