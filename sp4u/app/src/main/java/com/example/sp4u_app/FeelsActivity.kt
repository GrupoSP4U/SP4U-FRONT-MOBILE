package com.example.sp4u_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class FeelsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feels)
    }

    //    menu config

    fun goToHomeAuthenticated(button: View) {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    fun goToHumor(button: View) {
        val intent = Intent(this, FeelsActivity::class.java)
        startActivity(intent)
    }

    fun goToBasicSettings(button: View){
        val register = Intent(this, UserProfileActivity::class.java)
        startActivity(register)
    }

    fun goToEnterprise(button: View){
        val register = Intent(this, RegisterEstablishmentActivity::class.java)
        startActivity(register)
    }

//    fim menu config

}