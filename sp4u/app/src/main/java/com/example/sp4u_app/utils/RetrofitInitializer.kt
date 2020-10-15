package com.example.sp4u_app.utils

import com.example.sp4u_app.service.AuthenticateService
import com.example.sp4u_app.service.UserService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer(path: String = "http://ec2-34-229-98-39.compute-1.amazonaws.com:8081/") {

    private val retrofit = Retrofit.Builder()
        .baseUrl(path)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun authenticateService(): AuthenticateService = retrofit.create(AuthenticateService::class.java)

    fun userService(): UserService = retrofit.create(UserService::class.java)
}
