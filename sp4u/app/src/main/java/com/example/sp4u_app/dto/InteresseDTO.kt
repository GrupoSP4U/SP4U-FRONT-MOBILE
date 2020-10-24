package com.example.sp4u_app.dto

data class InteresseDTO (
    val id: Int,
    val statusDia: String,
    val acompanhado: String,
    val estiloRole: List<String>,
    val estiloMusica: List<String>
)
