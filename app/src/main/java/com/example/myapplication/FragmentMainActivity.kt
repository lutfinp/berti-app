package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentMainActivityBinding

class FragmentMainActivity : Fragment() {
    private lateinit var binding: FragmentMainActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainActivityBinding.inflate(inflater,container,false)
        with(binding) {
            ger.setOnClickListener {
                startActivity(Intent(context, SecondActivity::class.java))
            }

            bbc.setOnClickListener {
                startActivity(Intent(context, ThirdActivity::class.java))
            }

            us.setOnClickListener {
                startActivity(Intent(context,FourActivity::class.java))
            }
            return binding.root
        }
    }
}