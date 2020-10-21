package com.example.sp4u_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class UserProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)
    }

    fun goToEmailEditing(button: View){
        val register = Intent(this, UserProfile2Activity::class.java)
        startActivity(register)
    }

    fun goToPasswordEditing(button: View){
        val register = Intent(this, UserProfile3Activity::class.java)
        startActivity(register)
    }
}