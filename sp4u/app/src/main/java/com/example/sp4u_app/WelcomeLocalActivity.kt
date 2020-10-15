package com.example.sp4u_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class WelcomeLocalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_local)
    }

    fun goToHomeLeavingLocal(component: View){
        val userId = intent.getIntExtra("USER_ID", 0)
        val token = intent.getStringExtra("TOKEN")
        val homeIntent = Intent(this, HomeActivity::class.java)
        homeIntent.putExtra("USER_ID", userId)
        homeIntent.putExtra("TOKEN", token)

        startActivity(homeIntent)
    }
}
