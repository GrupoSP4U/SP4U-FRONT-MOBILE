package com.example.sp4u_app.activity.register

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.view.get
import com.example.sp4u_app.R
import com.example.sp4u_app.activity.welcome.WelcomeMusicActivity
import com.example.sp4u_app.dto.request.AuthenticateRequestDTO
import com.example.sp4u_app.dto.UserDTO
import com.example.sp4u_app.utils.RetrofitInitializer
import com.example.sp4u_app.utils.AbstractAuthenticateActivity
import com.example.sp4u_app.utils.buildSpinner
import com.example.sp4u_app.validator.validator
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register_establishment_config_description.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.sql.Date
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
class RegisterActivity : AbstractAuthenticateActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        buildSpinner(baseContext, ps_genero, listOf("feminino", "masculino"))
    }

    fun register(component: View) {
        if (!validator(
                listOf(
                    et_nome, et_nome_social, et_nascimento, et_telefone,
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

    private fun buildRegisterRequestDTO(): UserDTO {
        return UserDTO(
            nomeCompleto = et_nome.text.toString(),
            nomeSocial = et_nome_social.text.toString(),
            dataNascimento = et_nascimento.text.toString(),
            genero = ps_genero.selectedItem.toString(),
            email = et_email.text.toString(),
            telefone = et_telefone.text.toString(),
            senha = et_senha.text.toString()
        )
    }

    private fun callRegisterEndpoint(request: UserDTO) {
        val call =
            RetrofitInitializer()
                .userService()
                .register(register = request)

        call.enqueue(object : Callback<Void?> {
            override fun onResponse(
                call: Call<Void?>?,
                response: Response<Void?>?
            ) {
                when (response?.code()) {
                    201 -> callLoginEndpoint(
                        AuthenticateRequestDTO(
                            email = request.email,
                            password = request.senha
                        ),
                        WelcomeMusicActivity().javaClass
                    )
                    400 -> Toast.makeText(
                        this@RegisterActivity,
                        resources.getString(R.string.requisicao_email_ja_cadastrado),
                        Toast.LENGTH_SHORT
                    ).show()
                    else -> Toast.makeText(
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
