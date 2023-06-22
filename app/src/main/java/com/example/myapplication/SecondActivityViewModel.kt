package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondActivityViewModel(private val operasi: Int): ViewModel() {
    val data = MutableLiveData<Int>()

    fun tambah(){
        val nilaiSaatIni = data.value ?: 0
        data.value = nilaiSaatIni + operasi
    }

    fun kurang(){
        val nilaiSaatIni = data.value ?: 0
        data.value = nilaiSaatIni - operasi
    }

}