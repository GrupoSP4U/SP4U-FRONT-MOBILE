package com.example.sp4u_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class WelcomeMusicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_music)
    }

    fun goToWelcomeLocal(component: View) {
        val userId = intent.getIntExtra("USER_ID", 0)
        val token = intent.getStringExtra("TOKEN")

        val welcomeLocalIntent = Intent(this, WelcomeLocalActivity::class.java)
        welcomeLocalIntent.putExtra("USER_ID", userId)
        welcomeLocalIntent.putExtra("TOKEN", token)
        startActivity(welcomeLocalIntent)
    }
}
