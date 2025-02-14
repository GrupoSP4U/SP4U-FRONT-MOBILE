package com.example.sp4u_app.dto

import java.util.*

data class UserDTO(
    val nomeCompleto: String,
    val telefone: String,
    val nomeSocial: String,
    val dataNascimento: String,
    val genero: String,
    val email: String,
    val senha: String,
    val interesses: InteresseDTO? = null,
    val estabelecimentos: List<EstabelecimentoDTO>? = null
)
