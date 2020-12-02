package com.example.sp4u_app.service

import com.example.sp4u_app.dto.EstabelecimentoDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface EstablishmentService {
    @POST("/estabelecimentos")
    fun register(@Body registerEstablishment: EstabelecimentoDTO?): Call<Void>

    @GET("/estabelecimentos/user/{userId}")
    fun getById(@Path("userId") userId: Int?): Call<EstabelecimentoDTO?>
}
