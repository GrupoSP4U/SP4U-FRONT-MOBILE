package com.example.sp4u_app.utils

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sp4u_app.*
import com.example.sp4u_app.activity.AboutEstabilishmentActivity
import com.example.sp4u_app.activity.FeelsActivity
import com.example.sp4u_app.activity.HomeActivity
import com.example.sp4u_app.activity.LoginActivity
import com.example.sp4u_app.activity.register.*
import com.example.sp4u_app.activity.user.UserProfileEmailActivity
import com.example.sp4u_app.activity.user.UserProfilePasswordActivity
import com.example.sp4u_app.activity.user.UserProfileConfigActivity

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
        navigate(userId, token, UserProfileConfigActivity().javaClass)
    }

    fun goToEnterprise(button: View) {
        navigate(userId, token, RegisterEstablishmentActivity().javaClass)
    }

    fun goToHome(button: View) {
        navigate(userId, token, HomeActivity().javaClass)
    }

    fun goToPasswordEditing(button: View) {
        navigate(userId, token, UserProfilePasswordActivity().javaClass)
    }

    fun goToEmailEditing(button: View) {
        navigate(userId, token, UserProfileEmailActivity().javaClass)
    }

    fun goToRegisterEstablishmentMusic(button: View){
        navigate(userId, token, RegisterEstablishmentMusicActivity().javaClass)
    }

    fun goToRegisterEstablishmentAddress(button: View){
        navigate(userId, token, RegisterEstablishmentAdressActivity().javaClass)
    }

    fun goToRegisterEstablishment(button: View){
        navigate(userId, token, RegisterEstablishmentPrincipalActivity().javaClass)
    }

    fun goToRegisterEstablishmentFilters(button: View){
        navigate(userId, token, RegisterEstablishmentFiltersActivity().javaClass)
    }

    fun goToRegisterEstablishmentLocal(button: View){
        navigate(userId, token, RegisterEstablishmentLocalActivity().javaClass)
    }

    fun goToEstablishmentConfig(button: View){
        navigate(userId, token, RegisterEstablishmentConfigActivity().javaClass)
    }

    fun goToAbout(button: View){
        navigate(userId, token, AboutEstabilishmentActivity().javaClass)
    }
}
