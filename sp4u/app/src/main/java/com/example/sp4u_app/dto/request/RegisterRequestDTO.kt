package com.example.sp4u_app.dto.request

data class RegisterRequestDTO(
    var nomeCompleto: String,
    var telefone: String,
    var nomeSocial: String,
    var dataNascimento: String,
    var genero: String,
    var email: String,
    var senha: String
)
