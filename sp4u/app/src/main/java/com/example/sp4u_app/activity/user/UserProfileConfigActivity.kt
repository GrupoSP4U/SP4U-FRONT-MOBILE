package com.example.sp4u_app.activity.user

import android.os.Bundle
import android.widget.Toast
import com.example.sp4u_app.R
import com.example.sp4u_app.dto.response.UserResponseDTO
import com.example.sp4u_app.utils.AbstractActivity
import com.example.sp4u_app.utils.RetrofitInitializer
import kotlinx.android.synthetic.main.activity_user_profile_config.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class UserProfileConfigActivity : AbstractActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile_config)
        setVariables()
        callGetUser()
    }

    private fun callGetUser() {
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
                        val sf = SimpleDateFormat("yyyy-MM-dd")
                        tv_usuario.setText(it.usuario.nomeSocial)
                        et_nome.setText(it.usuario.nomeCompleto)
                        et_nome_social.setText(it.usuario.nomeSocial)
                        et_data_nasc.setText(sf.format(Date(it.usuario.dataNascimento.toLong())))
                        et_email.setText(it.usuario.email)
                        et_telefone.setText(it.usuario.telefone)
                        et_genero.setText(it.usuario.genero)
                        et_genero.setText(it.usuario.genero)
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
