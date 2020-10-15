package com.example.sp4u_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sp4u_app.dto.request.AuthenticateRequestDTO
import com.example.sp4u_app.dto.request.RegisterRequestDTO
import com.example.sp4u_app.dto.response.AuthenticateResponseDTO
import com.example.sp4u_app.utils.RetrofitInitializer
import com.example.sp4u_app.validator.validator
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    fun register(component: View) {
        if (!validator(
                listOf(
                    et_nome, et_nome_social, et_nascimento, et_telefone, et_genero,
                    et_email, et_senha, et_confirmar_senha
                )
            )
        ) {
            return
        }

        if (et_senha.text.toString() != et_confirmar_senha.text.toString()) {
            et_confirmar_senha.error = resources.getString(R.string.validator_senhas_diferentes)
        }

        val register = buildRegisterRequestDTO()

        callEndpoint(register)
    }

    private fun goToWelcomeMusic(body: AuthenticateResponseDTO) {
        val welcomeMusicIntent = Intent(this, WelcomeMusicActivity::class.java)
        welcomeMusicIntent.putExtra("USER_ID", body.userId)
        welcomeMusicIntent.putExtra("TOKEN", body.jwttoken)
        startActivity(welcomeMusicIntent)
    }

    private fun buildRegisterRequestDTO(): RegisterRequestDTO {
        return RegisterRequestDTO(
            nomeCompleto = et_nome.text.toString(),
            nomeSocial = et_nome_social.text.toString(),
            dataNascimento = et_nascimento.text.toString(),
            genero = et_genero.text.toString(),
            email = et_email.text.toString(),
            telefone = et_telefone.text.toString(),
            senha = et_senha.text.toString()
        )
    }

    private fun callEndpoint(request: RegisterRequestDTO) {
        val call =
            RetrofitInitializer()
                .userService()
                .register(register = request)


        call.enqueue(object : Callback<Void?> {
            override fun onResponse(
                call: Call<Void?>?,
                response: Response<Void?>?
            ) {
                if (response?.code() == 201) {
                    callEndpointLogin(
                        AuthenticateRequestDTO(
                            email = request.email,
                            password = request.senha
                        )
                    )
                } else if (response?.code() == 400) {
                    Toast.makeText(
                        this@RegisterActivity,
                        resources.getString(R.string.email_ja_cadastrado),
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        this@RegisterActivity,
                        resources.getString(R.string.erro_interno),
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

    private fun callEndpointLogin(request: AuthenticateRequestDTO) {
        val call =
            RetrofitInitializer("http://ec2-100-26-215-123.compute-1.amazonaws.com:8080/")
                .authenticateService()
                .authenticate(request)

        call.enqueue(object : Callback<AuthenticateResponseDTO?> {
            override fun onResponse(
                call: Call<AuthenticateResponseDTO?>?,
                response: Response<AuthenticateResponseDTO?>?
            ) {
                if (response?.code() == 200) {
                    response?.body()?.let {
                        goToWelcomeMusic(it)
                    }
                } else if (response?.code() == 404) {
                    Toast.makeText(
                        this@RegisterActivity,
                        resources.getString(R.string.erro_interno),
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
