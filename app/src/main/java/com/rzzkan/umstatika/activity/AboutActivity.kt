package com.rzzkan.umstatika.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rzzkan.umstatika.R
import com.rzzkan.umstatika.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var binding:ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clickListener()
    }

    private fun clickListener(){
        binding.ibBack.setOnClickListener{
            finish()
        }

        binding.ibFacebook.setOnClickListener{
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/ftumsumbar")))
        }

        binding.ibInstagram.setOnClickListener{
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/fakultasteknikumsumbar")))
        }

        binding.ibWeb.setOnClickListener{
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://prodi-sipil.umsb.ac.id/")))
        }
    }
}