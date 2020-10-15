package com.example.sp4u_app.service

import com.example.sp4u_app.dto.request.AuthenticateRequestDTO
import com.example.sp4u_app.dto.response.AuthenticateResponseDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticateService {
    @POST("authenticate")
    fun authenticate(@Body authenticate: AuthenticateRequestDTO): Call<AuthenticateResponseDTO>
}
