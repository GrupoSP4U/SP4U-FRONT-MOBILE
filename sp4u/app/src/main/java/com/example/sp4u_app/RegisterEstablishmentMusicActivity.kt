package com.example.sp4u_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class RegisterEstablishmentMusicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_establishment_music)
    }

    fun goToRegisterEstablishmentLocal(button: View){
        val registerLocal = Intent(this, RegisterEstablishmentLocalActivity::class.java)
        startActivity(registerLocal)
    }
}