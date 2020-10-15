package com.example.sp4u_app.utils

import com.example.sp4u_app.service.AuthenticateService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer(path: String) {

    private val retrofit = Retrofit.Builder()
        .baseUrl(path)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun authenticateService(): AuthenticateService = retrofit.create(AuthenticateService::class.java)
}
