package com.example.sp4u_app.service

import com.example.sp4u_app.dto.request.ChangePasswordRequestDTO
import com.example.sp4u_app.dto.UserDTO
import com.example.sp4u_app.dto.response.UserResponseDTO
import retrofit2.Call
import retrofit2.http.*

interface UserService {
    @GET("usuario/{id}")
    fun getById(@Path("id") id: Int?): Call<UserResponseDTO>

    @POST("usuario/register")
    fun register(@Body register: UserDTO): Call<Void>

    @POST("usuario/email")
    fun changeEmail(@Query(value = "newEmail") newEmail: String): Call<Void>

    @PUT("usuario/password")
    fun changePassword(@Body changePassword: ChangePasswordRequestDTO): Call<Void>
}
