package com.example.sp4u_app.dto.response

data class AuthenticateResponseDTO(
    var userId : Int,
    var jwttoken : String,
    var nomeSocial: String
)
