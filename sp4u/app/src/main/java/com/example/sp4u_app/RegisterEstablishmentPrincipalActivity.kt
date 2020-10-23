package com.example.sp4u_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class RegisterEstablishmentPrincipalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_establishment_principal)
    }

    fun goToRegisterEstablishmentAdress(button: View){
        val registerAdress = Intent(this, RegisterEstablishmentAdressActivity::class.java)
        startActivity(registerAdress)
    }
}
