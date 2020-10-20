package com.example.sp4u_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class RegisterEstabilishmentConfigActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_estabilishment_config)
    }

    fun goToDescriptionOfRole(textView:View){
        val estabilishmentConfigDescription = Intent(this, RegisterEstabilishmentConfigDescriptionActivity::class.java)
        startActivity(estabilishmentConfigDescription)
    }
}