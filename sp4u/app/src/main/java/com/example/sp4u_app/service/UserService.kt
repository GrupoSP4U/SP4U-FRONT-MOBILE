package com.example.sp4u_app.service

import com.example.sp4u_app.dto.request.ChangePasswordRequestDTO
import com.example.sp4u_app.dto.request.RegisterRequestDTO
import retrofit2.Call
import retrofit2.http.*

interface UserService {
    @POST("usuario/register")
    fun register(@Body register: RegisterRequestDTO): Call<Void>

    @POST("usuario/email")
    fun changeEmail(@Query(value = "newEmail") newEmail: String): Call<Void>

    @PUT("usuario/password")
    fun changePassword(@Body changePassword: ChangePasswordRequestDTO): Call<Void>
}
