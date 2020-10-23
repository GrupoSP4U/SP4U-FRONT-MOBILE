package com.example.sp4u_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class RegisterEstablishmentActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_establishment)
    }

    fun goToregisterEstablishment(button: View){
        val registerEstablishment = Intent(this, RegisterEstablishmentPrincipalActivity::class.java)
        startActivity(registerEstablishment)
    }
}
