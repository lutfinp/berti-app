package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityFourBinding

class FourActivity : AppCompatActivity() {

    private val viewModel by viewModels<FourActivityViewModel>()
    private lateinit var binding: ActivityFourBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            viewModel.getNewsUSList()

            viewModel.newsUSList.observe(this@FourActivity) {
                recyclerView.setHasFixedSize(true)
                recyclerView.layoutManager = LinearLayoutManager(this@FourActivity)
                recyclerView.adapter = Adapter3(it)
            }
        }
    }
}