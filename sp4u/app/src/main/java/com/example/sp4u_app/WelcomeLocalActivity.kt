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

    fun goToHomeLeavingLocal(){
        val leavingLocal = Intent(this, LoginActivity::class.java)
        startActivity(leavingLocal)
    }
}