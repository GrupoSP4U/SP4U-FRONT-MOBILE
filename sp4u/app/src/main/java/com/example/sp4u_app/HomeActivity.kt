package com.example.sp4u_app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val userId = intent.getIntExtra("USER_ID", 0)
        val token = intent.getStringExtra("TOKEN")

        if(userId == 0) {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}
