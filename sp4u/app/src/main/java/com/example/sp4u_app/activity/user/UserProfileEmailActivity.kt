package com.example.sp4u_app.activity.user

import android.os.Bundle
import android.view.View

import android.widget.Toast
import com.example.sp4u_app.R
import com.example.sp4u_app.dto.response.UserResponseDTO
import com.example.sp4u_app.utils.AbstractActivity
import com.example.sp4u_app.utils.RetrofitInitializer
import com.example.sp4u_app.validator.validator
import kotlinx.android.synthetic.main.activity_user_profile_email.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserProfileEmailActivity : AbstractActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile_email)
        setVariables()
        callGetEmail()
    }

    fun changeEmail(component: View) {
        if (!validator(listOf(et_confirma_email_novo, et_email_novo))) {
            return
        }

        if (et_email_novo.text.toString() != et_confirma_email_novo.text.toString()) {
            et_confirma_email_novo.error = resources.getString(R.string.validator_emails_diferentes)
            return
        }

        callChangeEmailEndpoint(et_confirma_email_novo.text.toString())
    }

    private fun callChangeEmailEndpoint(newEmail: String) {
        val call = RetrofitInitializer(token).userService().changeEmail(
            newEmail = newEmail
        )

        call.enqueue(object : Callback<Void?> {
            override fun onResponse(
                call: Call<Void?>?,
                response: Response<Void?>?
            ) {
                if (response?.code() == 200) {
                    Toast.makeText(
                        this@UserProfileEmailActivity,
                        resources.getString(R.string.user_email_alterado),
                        Toast.LENGTH_LONG
                    ).show()
                } else if (response?.code() == 400) {
                    Toast.makeText(
                        this@UserProfileEmailActivity,
                        resources.getString(R.string.user_email_nao_existe),
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    println(response.toString())
                    Toast.makeText(
                        this@UserProfileEmailActivity,
                        resources.getString(R.string.requisicao_erro_interno),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(
                call: Call<Void?>?,
                t: Throwable?
            ) {
                println(t.toString())
            }
        })
    }

    private fun callGetEmail() {
        val call =
            RetrofitInitializer(token)
                .userService()
                .getById(userId)

        call.enqueue(object : Callback<UserResponseDTO?> {
            override fun onResponse(
                call: Call<UserResponseDTO?>?,
                response: Response<UserResponseDTO?>?
            ) {
                if (response?.code() == 200) {
                    response?.body()?.let {
                        tv_email_antigo.text = it.usuario.email
                    }
                } else if (response?.code() == 404) {
                    Toast.makeText(
                        applicationContext,
                        resources.getString(R.string.requisicao_erro_interno),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(
                call: Call<UserResponseDTO?>?,
                t: Throwable?
            ) {
                println(t.toString())
            }
        })
    }
}
