package com.example.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch

val Context.datastore: DataStore<Preferences> by preferencesDataStore(name = "akun")

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val viewModel by viewModels<LoginViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        with(binding){
            imgBack.setOnClickListener {
                startActivity(Intent(this@LoginActivity,ActivityPertama::class.java))
            }
            txtRegister.setOnClickListener {
                startActivity(Intent(this@LoginActivity,RegisterActivity::class.java))
            }
            btnLogin.setOnClickListener {
                lifecycleScope.launch {
                    val passwordAkun = viewModel.cariAkun(edtUsername.text.toString())
                    if (passwordAkun == edtPass.text.toString()){
                        startActivity(Intent(this@LoginActivity,MainActivity::class.java))
                    }
                    else Snackbar.make(root,"Login Gagal",Snackbar.LENGTH_SHORT).show()
                }
            }
        }
    }
}