package com.rzzkan.umstatika.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.rzzkan.umstatika.databinding.ActivityTheoryBinding
import java.io.File

class TheoryActivity : AppCompatActivity() {
    private lateinit var binding:ActivityTheoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTheoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
        clickListener()
    }

    private fun getData(){
        var title = intent.getStringExtra("title")
        Log.d("cek",title.toString())
        if (title.equals("1. beban terpusat",true)){
            binding.pdfView.fromAsset("terpusat.pdf").load()
        }
        else if (title.equals("2. beban merata",true)){
            binding.pdfView.fromAsset("merata.pdf").load()
        }
        else if (title.equals("3. beban segitiga",true)){
            binding.pdfView.fromAsset("segitiga.pdf").load()
        }


    }

    private fun clickListener(){
        binding.ibBack.setOnClickListener{
            finish()
        }
    }
}