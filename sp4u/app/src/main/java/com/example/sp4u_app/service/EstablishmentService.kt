package com.example.sp4u_app.service

import com.example.sp4u_app.dto.EstabelecimentoDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface EstablishmentService {
    @POST("/estabelecimentos")
    fun register(@Body registerEstablishment: EstabelecimentoDTO?): Call<Void>
}
