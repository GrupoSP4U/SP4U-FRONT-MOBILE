package com.example.sp4u_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.sp4u_app.R
import com.example.sp4u_app.RegisterEstablishmentMusicActivity

class RegisterEstablishmentLocalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_establishment_local)
    }

    fun goToRegisterEstablishmentFilters(button: View){
        val registerFilters = Intent(this, RegisterEstablishmentFiltersActivity::class.java)
        startActivity(registerFilters)
    }

}