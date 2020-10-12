package com.example.sp4u_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sp4u_app.dto.request.AuthenticateRequestDTO
import com.example.sp4u_app.dto.response.AuthenticateResponseDTO
import com.example.sp4u_app.utils.RetrofitInitializer
import com.example.sp4u_app.validator.validator
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun login(component: View) {
        if(!validator(listOf(et_email, et_senha))) {
            return
        }
        val authenticate = AuthenticateRequestDTO(et_email.text.toString(), et_senha.text.toString())
        val call =
            RetrofitInitializer("http://ec2-100-26-215-123.compute-1.amazonaws.com:8080/")
                .authenticateService()
                .authenticate(authenticate)

        call.enqueue(object: Callback<AuthenticateResponseDTO?> {
            override fun onResponse(call: Call<AuthenticateResponseDTO?>?,
                                    response: Response<AuthenticateResponseDTO?>?) {
                if(response?.code() == 200) {
                    response?.body()?.let {
                        val body: AuthenticateResponseDTO = it
                        println(body)
                        goToHome()
                    }
                } else if (response?.code() == 404) {
                    Toast.makeText(
                        this@LoginActivity,
                        resources.getString(R.string.login_errado),
                        Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<AuthenticateResponseDTO?>?,
                                   t: Throwable?) {
                println(t.toString())
            }
        })
    }

    fun goToForgotPassword(button: View){
        val forgotPassword = Intent(this, ForgotPasswordActivity::class.java)
        startActivity(forgotPassword)
    }

    fun goToRegister(button: View){
        val register = Intent(this, RegisterActivity::class.java)
        startActivity(register)
    }

    private fun goToHome(){
        val home = Intent(this, HomeActivity::class.java)
        startActivity(home)
    }
}
