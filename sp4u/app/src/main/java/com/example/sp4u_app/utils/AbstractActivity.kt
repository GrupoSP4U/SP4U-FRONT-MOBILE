package com.example.sp4u_app.utils

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sp4u_app.R
import com.example.sp4u_app.activity.AboutEstablishmentActivity
import com.example.sp4u_app.activity.FeelsActivity
import com.example.sp4u_app.activity.HomeActivity
import com.example.sp4u_app.activity.LoginActivity
import com.example.sp4u_app.activity.register.RegisterEstablishmentActivity
import com.example.sp4u_app.activity.register.RegisterEstablishmentConfigActivity
import com.example.sp4u_app.activity.register.RegisterEstablishmentPrincipalActivity
import com.example.sp4u_app.activity.user.UserProfileConfigActivity
import com.example.sp4u_app.activity.user.UserProfileEmailActivity
import com.example.sp4u_app.activity.user.UserProfilePasswordActivity
import com.example.sp4u_app.dto.EstabelecimentoDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

    fun navigate(activityClass: Class<Any>) {
        val intent = Intent(this, activityClass)
        intent.putExtra("USER_ID", userId)
        intent.putExtra("TOKEN", token)
        startActivity(intent)
    }

    fun navigateWithEstablishmentObject(establishment: EstabelecimentoDTO?, activityClass: Class<Any>) {
        val intent = Intent(this, activityClass)
        intent.putExtra("ESTABELECIMENTO", establishment)
        intent.putExtra("USER_ID", userId)
        intent.putExtra("TOKEN", token)
        startActivity(intent)
    }

    fun goToHumor(button: View) {
        navigate(FeelsActivity().javaClass)
    }

    fun goToBasicSettings(button: View) {
        navigate(UserProfileConfigActivity().javaClass)
    }

    fun goToEnterprise(button: View) {
        navigate(RegisterEstablishmentActivity().javaClass)
    }

    fun goToHome(button: View) {
        navigate(HomeActivity().javaClass)
    }

    fun goToPasswordEditing(button: View) {
        navigate(UserProfilePasswordActivity().javaClass)
    }

    fun goToEmailEditing(button: View) {
        navigate(UserProfileEmailActivity().javaClass)
    }

    fun goToRegisterEstablishment(button: View) {
        navigate(RegisterEstablishmentPrincipalActivity().javaClass)
    }

    fun goToAbout(button: View) {
        navigate(AboutEstablishmentActivity().javaClass)
    }

    fun searchEstablishment(button: View) {
        val call = RetrofitInitializer(token).establishmentService()
            .getById(userId)

        call.enqueue(object : Callback<EstabelecimentoDTO?> {
            override fun onResponse(
                call: Call<EstabelecimentoDTO?>?,
                response: Response<EstabelecimentoDTO?>?
            ) {
                when(response?.code()) {
                    200 -> {
                        val intent = Intent(baseContext, RegisterEstablishmentConfigActivity::class.java)
                        intent.putExtra("ESTABELECIMENTO", response?.body())
                        intent.putExtra("USER_ID", userId)
                        intent.putExtra("TOKEN", token)
                        startActivity(intent)
                    }
                    204 -> navigate(RegisterEstablishmentActivity().javaClass)
                    else -> {
                        Toast.makeText(
                            applicationContext,
                            resources.getString(R.string.requisicao_erro_interno),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }

            override fun onFailure(
                call: Call<EstabelecimentoDTO?>?,
                t: Throwable?
            ) {
                println(t.toString())
            }
        })
    }
}
