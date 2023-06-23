package com.example.myapplication


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentProfilBinding

class Profil : Fragment() {
    private lateinit var binding: FragmentProfilBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfilBinding.inflate(inflater,container,false)
        with(binding){
            btninstazikry.setOnClickListener{
                val intImplicit = Intent(Intent.ACTION_VIEW, Uri.parse("https:/instagram.com/mzikri36"))
                startActivity(intImplicit)
            }
            btninstalutfi.setOnClickListener{
                val intImplicit = Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/lutfi.np"))
                startActivity(intImplicit)
            }
        }
        return binding.root
    }
    }
