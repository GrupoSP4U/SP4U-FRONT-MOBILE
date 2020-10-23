package com.example.sp4u_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.sp4u_app.utils.AbstractActivity

class UserProfile2Activity : AbstractActivity() {

    private var userId: Int? = 0
    private var token: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile_2)
        userId = intent.getIntExtra("USER_ID", 0)
        token = intent.getStringExtra("TOKEN")
    }


    fun goToPasswordEditing(button: View){
        navigate(userId, token, UserProfile3Activity().javaClass)
    }

    //    menu config
    fun goToHomeAuthenticated(button: View) {
        navigate(userId, token, HomeActivity().javaClass)
    }

    fun goToHumor(button: View) {
        navigate(userId, token, FeelsActivity().javaClass)
    }

    fun goToBasicSettings(button: View){
        navigate(userId, token, UserProfileActivity().javaClass)
    }

    fun goToEnterprise(button: View){
        navigate(userId, token, RegisterEstablishmentActivity().javaClass)
    }
//    fim menu config

}