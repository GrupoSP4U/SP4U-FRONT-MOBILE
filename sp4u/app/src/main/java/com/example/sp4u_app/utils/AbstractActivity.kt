package com.example.sp4u_app.utils

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sp4u_app.*

abstract class AbstractActivity : AppCompatActivity() {
    protected var userId: Int? = 0
    protected var token: String? = ""

    fun setVariables() {
        token = intent.getStringExtra("TOKEN")
        userId = intent.getIntExtra("USER_ID", 0)

        if (userId == 0 || token.isNullOrBlank()) {
            Toast.makeText(
                applicationContext,
                resources.getString(R.string.requisicao_login_expirado),
                Toast.LENGTH_SHORT
            )
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    fun navigate(userId: Int?, token: String?, activityClass: Class<Any>) {
        val intent = Intent(this, activityClass)
        intent.putExtra("USER_ID", userId)
        intent.putExtra("TOKEN", token)
        startActivity(intent)
    }

    fun goToHumor(button: View) {
        navigate(userId, token, FeelsActivity().javaClass)
    }

    fun goToBasicSettings(button: View) {
        navigate(userId, token, UserProfileActivity().javaClass)
    }

    fun goToEnterprise(button: View) {
        navigate(userId, token, RegisterEstablishmentActivity().javaClass)
    }

    fun goToHome(button: View) {
        navigate(userId, token, HomeActivity().javaClass)
    }

    fun goToPasswordEditing(button: View) {
        navigate(userId, token, UserProfile3Activity().javaClass)
    }

    fun goToEmailEditing(button: View) {
        navigate(userId, token, UserProfile2Activity().javaClass)
    }
}
