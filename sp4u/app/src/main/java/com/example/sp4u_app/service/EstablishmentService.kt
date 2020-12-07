package com.example.sp4u_app.service

import com.example.sp4u_app.dto.EstabelecimentoDTO
import com.example.sp4u_app.dto.enums.Acompanhamento
import retrofit2.Call
import retrofit2.http.*

interface EstablishmentService {
    @POST("/estabelecimentos")
    fun register(@Body registerEstablishment: EstabelecimentoDTO?): Call<Void>

    @GET("/estabelecimentos/user/{userId}")
    fun getById(@Path("userId") userId: Int?): Call<EstabelecimentoDTO?>

    @GET("/estabelecimentos")
    fun getFilteredPlaces(@Query("acompanhado") acompanhado: Acompanhamento):
            Call<List<EstabelecimentoDTO>?>
}
