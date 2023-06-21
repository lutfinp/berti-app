package com.example.myapplication

import androidx.lifecycle.ViewModel


class MainActivityViewModel: ViewModel() {
    val data = DataActivity()
    fun tambah(){
        data.nilai++
    }
    fun kurang(){
        data.nilai--
    }
    fun ganti(){
        data.headphoneStatus = !data.headphoneStatus
    }
}