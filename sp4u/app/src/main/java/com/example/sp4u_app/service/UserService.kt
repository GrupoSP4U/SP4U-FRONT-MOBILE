package com.example.sp4u_app.service

import com.example.sp4u_app.dto.request.RegisterRequestDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {
    @POST("usuario/register")
    fun register(@Body register: RegisterRequestDTO): Call<Void>
}
