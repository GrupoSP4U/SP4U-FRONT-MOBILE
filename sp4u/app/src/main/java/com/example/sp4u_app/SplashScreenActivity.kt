package com.example.sp4u_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreenActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT : Long = 4000 // 1 seg
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        Handler().postDelayed({
            startActivity(Intent(this@SplashScreenActivity, LoginActivity::class.java))
            finish()
        },SPLASH_TIME_OUT)
    }
}