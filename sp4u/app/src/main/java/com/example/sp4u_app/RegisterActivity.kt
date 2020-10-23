package com.example.sp4u_app

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.sp4u_app.dto.request.AuthenticateRequestDTO
import com.example.sp4u_app.dto.request.RegisterRequestDTO
import com.example.sp4u_app.utils.RetrofitInitializer
import com.example.sp4u_app.utils.AbstractActivityOut
import com.example.sp4u_app.validator.validator
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AbstractActivityOut() {

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
            return
        }

        val register = buildRegisterRequestDTO()

        callRegisterEndpoint(register)
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

    private fun callRegisterEndpoint(request: RegisterRequestDTO) {
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
                    callLoginEndpoint(
                        AuthenticateRequestDTO(
                            email = request.email,
                            password = request.senha
                        ),
                        WelcomeMusicActivity().javaClass
                    )
                } else if (response?.code() == 400) {
                    Toast.makeText(
                        this@RegisterActivity,
                        resources.getString(R.string.requisicao_email_ja_cadastrado),
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        this@RegisterActivity,
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
}
