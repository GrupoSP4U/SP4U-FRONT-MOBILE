package com.example.sp4u_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.sp4u_app.dto.request.AuthenticateRequestDTO
import com.example.sp4u_app.utils.AbstractAuthenticateActivity
import com.example.sp4u_app.validator.validator
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AbstractAuthenticateActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun login(component: View) {
        if (!validator(listOf(et_email, et_senha))) {
            return
        }
        val request = AuthenticateRequestDTO(
            email = et_email.text.toString(),
            password = et_senha.text.toString()
        )

        callLoginEndpoint(request, HomeActivity().javaClass)
    }

    fun goToForgotPassword(button: View) {
        val forgotPassword = Intent(this, ForgotPasswordActivity::class.java)
        startActivity(forgotPassword)
    }

    fun goToRegister(button: View) {
        val register = Intent(this, RegisterActivity::class.java)
        startActivity(register)
    }
}
