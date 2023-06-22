package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewmodel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with (binding){

            angka.text = viewmodel.data.nilai.toString()
            if (viewmodel.data.headphoneStatus) headphone.setImageResource(R.drawable.ic_baseline_headset_24)
            else headphone.setImageResource(R.drawable.ic_baseline_headset_off_24)

            headphone.apply {
                setOnClickListener{
                    viewmodel.ganti()
                    if (viewmodel.data.headphoneStatus) headphone.setImageResource(R.drawable.ic_baseline_headset_24)
                    else headphone.setImageResource(R.drawable.ic_baseline_headset_off_24)
                }
            }

            plus.setOnClickListener{
                viewmodel.tambah()
                angka.text = viewmodel.data.nilai.toString()
            }

            minus.setOnClickListener{
                viewmodel.kurang()
                angka.text = viewmodel.data.nilai.toString()
            }

            toSecond.setOnClickListener{
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                intent.putExtra("OPERASI", viewmodel.data.nilai)
                startActivity(intent)
            }
        }
    }
}