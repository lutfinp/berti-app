package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.myapplication.databinding.ActivityPertamaBinding


class ActivityPertama : AppCompatActivity() {

    private lateinit var binding: ActivityPertamaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityPertamaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        with(binding){
            btn1.setOnClickListener {
                startActivity(Intent(this@ActivityPertama,LoginActivity::class.java))
            }
            btn2.setOnClickListener {
                startActivity(Intent(this@ActivityPertama,RegisterActivity::class.java))
            }
        }
    }

}