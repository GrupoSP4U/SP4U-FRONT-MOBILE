package com.example.sp4u_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.sp4u_app.utils.AbstractActivity

class FeelsActivity : AbstractActivity() {

    private var userId: Int? = 0
    private var token: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feels)
        userId = intent.getIntExtra("USER_ID", 0)
        token = intent.getStringExtra("TOKEN")
    }

    fun goToAdditionalFilters(button: View) {
        navigate(userId, token, AdditionalFiltersActivity().javaClass)
    }

    //    menu config

    fun goToHomeAuthenticated(button: View) {
        navigate(userId, token, HomeActivity().javaClass)
    }

    fun goToHumor(button: View) {
        val intent = Intent(this, FeelsActivity::class.java)
        startActivity(intent)
    }

    fun goToBasicSettings(button: View) {
        val register = Intent(this, UserProfileActivity::class.java)
        startActivity(register)
    }

    fun goToEnterprise(button: View) {
        val register = Intent(this, RegisterEstablishmentActivity::class.java)
        startActivity(register)
    }

//    fim menu config

}