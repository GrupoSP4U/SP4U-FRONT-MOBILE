package com.example.sp4u_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class UserProfile3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile_3)
    }

    fun goToBasicSettings(button: View){
        val register = Intent(this, UserProfileActivity::class.java)
        startActivity(register)
    }

    fun goToEmailEditing(button: View){
        val register = Intent(this, UserProfile2Activity::class.java)
        startActivity(register)
    }
}