package com.example.sp4u_app.utils

import android.content.Intent
import android.widget.Toast
import com.example.sp4u_app.R
import com.example.sp4u_app.dto.request.AuthenticateRequestDTO
import com.example.sp4u_app.dto.response.AuthenticateResponseDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract class AbstractAuthenticateActivity : AbstractActivity() {
    fun callLoginEndpoint(request: AuthenticateRequestDTO, activityClass: Class<Any>) {
        val call =
            RetrofitInitializer("", "http://ec2-107-23-7-31.compute-1.amazonaws.com:8080/")
                .authenticateService()
                .authenticate(request)

        call.enqueue(object : Callback<AuthenticateResponseDTO?> {
            override fun onResponse(
                call: Call<AuthenticateResponseDTO?>?,
                response: Response<AuthenticateResponseDTO?>?
            ) {
                if (response?.code() == 200) {
                    response?.body()?.let {
                        val intent = Intent(baseContext, activityClass)
                        intent.putExtra("USER_ID", it.userId)
                        intent.putExtra("TOKEN", it.jwttoken)
                        startActivity(intent)
                    }
                } else if (response?.code() == 404) {
                    Toast.makeText(
                        applicationContext,
                        resources.getString(R.string.login_senha_email_incorreto),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(
                call: Call<AuthenticateResponseDTO?>?,
                t: Throwable?
            ) {
                println(t.toString())
            }
        })
    }
}
