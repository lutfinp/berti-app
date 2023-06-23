package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityRegisterBinding
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityRegisterBinding
    private val viewModel by viewModels<LoginViewModel>()
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        with(binding)
        {
            btnRegis.setOnClickListener {
                lifecycleScope.launch {
                    if (autentikasi())
                    {
                        viewModel.buatAkun(
                            edtUsername.text.toString(),
                            edtPass.text.toString()
                        )
                        Toast.makeText(this@RegisterActivity, "Akun berhasil dibuat", Toast.LENGTH_SHORT).show()
                        finish()
                        startActivity(Intent(this@RegisterActivity,LoginActivity::class.java))
                    }
                    else {
                        Snackbar.make(root,"Gagal Membuat Akun", Snackbar.LENGTH_SHORT).show()
                    }
                }
            }
            txtLogin.setOnClickListener {
                startActivity(Intent(this@RegisterActivity,LoginActivity::class.java))
            }
            gmbrBack.setOnClickListener {
                startActivity(Intent(this@RegisterActivity,ActivityPertama::class.java))
            }
        }
    }
    suspend fun autentikasi(): Boolean{
        with(binding){
            if (edtUsername.text.isNullOrEmpty()) return false
            else if(edtPass.text.isNullOrEmpty()) return false
            else if(edtConfirmPass.text.isNullOrEmpty()) return false
            else if(edtPass.text.toString() != edtConfirmPass.text.toString()) return false
            else return viewModel.cariAkun(edtUsername.text.toString()) == null
        }
    }

}