package com.rzzkan.umstatika.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatDelegate
import com.bumptech.glide.Glide
import com.rzzkan.umstatika.R
import com.rzzkan.umstatika.databinding.ActivitySplashscreenBinding

class SplashscreenActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySplashscreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//        Glide.with(this).load(R.drawable.logo).into(binding.ivLogo);
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@SplashscreenActivity, MainActivity::class.java))
            finish()
        },3000)
    }
}