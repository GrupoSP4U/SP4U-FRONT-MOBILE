package com.example.sp4u_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class RegisterEstablishmentAdressActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_establishment_adress)
    }

    fun goToRegisterEstablishmentMusic(button: View){
        val registerMusic = Intent(this, RegisterEstablishmentMusicActivity::class.java)
        startActivity(registerMusic)
    }

}