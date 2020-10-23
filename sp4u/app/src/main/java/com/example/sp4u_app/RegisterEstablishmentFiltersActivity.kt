package com.example.sp4u_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class RegisterEstablishmentFiltersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_establishment_filters)
    }

    fun goToHomeAuthenticated(button: View) {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

}