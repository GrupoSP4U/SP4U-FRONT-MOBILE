package com.example.sp4u_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
    fun goToForgotPassword(button:View){
        val forgotPassword = Intent(this, ForgotPasswordActivity::class.java)
        startActivity(forgotPassword)
    }

    fun goToRegister(button: View){
        val register = Intent(this, RegisterActivity::class.java)
        startActivity(register)
    }

    fun goToHome2(button:View){
        val home = Intent(this, HomeActivity::class.java)
        startActivity(home)
    }
}