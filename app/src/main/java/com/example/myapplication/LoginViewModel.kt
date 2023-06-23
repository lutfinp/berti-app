package com.example.myapplication

import android.app.Application
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.firstOrNull

class LoginViewModel(app: Application): AndroidViewModel(app) {
        private val dataStore: DataStore<Preferences> = app.applicationContext.datastore

        suspend fun buatAkun(usernameBaru: String, passwordBaru: String){
            dataStore.edit {
                it[stringPreferencesKey(usernameBaru)] = passwordBaru
            }
        }
        suspend fun cariAkun(username: String): String? = dataStore.data.firstOrNull()?.get(
            stringPreferencesKey(username)
        )
}
