package com.example.sp4u_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.sp4u_app.dto.response.AuthenticateResponseDTO
import com.example.sp4u_app.utils.AbstractActivity

class UserProfileActivity : AbstractActivity() {

    private var userId: Int? = 0
    private var token: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)
        userId = intent.getIntExtra("USER_ID", 0)
        token = intent.getStringExtra("TOKEN")
    }

    fun goToEmailEditing(button: View){
        navigate(userId, token, UserProfile2Activity().javaClass)
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
        navigate(userId, token, UserProfile2Activity().javaClass)
    }

    fun goToEnterprise(button: View){
        navigate(userId, token, RegisterEstablishmentActivity().javaClass)
    }
//    fim menu config
}