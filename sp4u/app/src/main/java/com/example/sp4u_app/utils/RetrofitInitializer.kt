package com.example.sp4u_app.utils

import com.example.sp4u_app.service.AuthenticateService
import com.example.sp4u_app.service.EstablishmentService
import com.example.sp4u_app.service.UserService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer(
    token: String? = "",
    path: String = "http://ec2-100-26-253-161.compute-1.amazonaws.com:8081/"
) {
    private val interceptor = TokenInterceptor(token)
    private val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

    private val retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl(path)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun authenticateService(): AuthenticateService =
        retrofit.create(AuthenticateService::class.java)

    fun userService(): UserService = retrofit.create(UserService::class.java)

    fun establishmentService(): EstablishmentService =
        retrofit.create(EstablishmentService::class.java)
}
