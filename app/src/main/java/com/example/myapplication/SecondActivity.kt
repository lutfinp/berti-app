package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var nilaiOperasi = 1
        if (intent.hasExtra("OPERASI")){
            nilaiOperasi = intent.getIntExtra("OPERASI", 1)
        }

        val viewModel = ViewModelProvider(
            this,
            SecondActivityVMFactory(nilaiOperasi)
        )[SecondActivityViewModel::class.java]

        with(binding){
            viewModel.data.observe(this@SecondActivity){
                angka.text = it.toString()
            }

            plus.setOnClickListener{ viewModel.tambah()}
            minus.setOnClickListener{ viewModel.kurang()}
        }
    }


}