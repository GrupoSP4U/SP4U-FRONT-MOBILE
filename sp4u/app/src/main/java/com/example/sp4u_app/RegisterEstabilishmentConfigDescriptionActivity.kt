package com.example.sp4u_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class RegisterEstabilishmentConfigDescriptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_estabilishment_config_description)
    }

    fun goToBasicConfig(textView:View){
        val estabilishmentConfig = Intent(this, RegisterEstabilishmentConfigActivity::class.java)
        startActivity(estabilishmentConfig)
    }

}