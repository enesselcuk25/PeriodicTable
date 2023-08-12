package com.example.periodictable.ui.animation


import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.example.periodictable.databinding.ActivitySplashBinding
import com.example.periodictable.ui.HomeActivity
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        definition()
    }

    private fun definition() {
        object : CountDownTimer(9000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
                finish()
            }
        }.start()
    }
}

