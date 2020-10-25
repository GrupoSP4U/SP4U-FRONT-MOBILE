package com.example.sp4u_app.activity.user

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.sp4u_app.R
import com.example.sp4u_app.dto.request.ChangePasswordRequestDTO
import com.example.sp4u_app.utils.AbstractActivity
import com.example.sp4u_app.utils.RetrofitInitializer
import com.example.sp4u_app.validator.validator
import kotlinx.android.synthetic.main.activity_user_profile_password.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserProfilePasswordActivity : AbstractActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile_password)
        setVariables()
    }

    fun changePassword(component: View) {
        if (!validator(listOf(et_senha_antiga, et_senha_nova, et_confirma_senha_nova))) {
            return
        }

        if (et_senha_nova.text.toString() != et_confirma_senha_nova.text.toString()) {
            et_confirma_senha_nova.error = resources.getString(R.string.validator_senhas_diferentes)
        }

        callChangePasswordEndpoint(
            ChangePasswordRequestDTO(
                et_senha_antiga.text.toString(),
                et_senha_nova.text.toString()
            )
        )
    }

    private fun callChangePasswordEndpoint(request: ChangePasswordRequestDTO) {
        val call = RetrofitInitializer(token).userService().changePassword(request)

        call.enqueue(object : Callback<Void?> {
            override fun onResponse(
                call: Call<Void?>?,
                response: Response<Void?>?
            ) {
                if (response?.code() == 200) {
                    Toast.makeText(
                        this@UserProfilePasswordActivity,
                        resources.getString(R.string.user_senha_alterada),
                        Toast.LENGTH_LONG
                    ).show()
                } else if (response?.code() == 400) {
                    Toast.makeText(
                        this@UserProfilePasswordActivity,
                        resources.getString(R.string.user_senha_incorreta),
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    println(response.toString())
                    Toast.makeText(
                        this@UserProfilePasswordActivity,
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
