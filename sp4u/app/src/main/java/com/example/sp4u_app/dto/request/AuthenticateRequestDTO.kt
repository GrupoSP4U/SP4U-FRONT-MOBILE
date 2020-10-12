package com.example.sp4u_app.dto.request

import org.jetbrains.annotations.NotNull

data class AuthenticateRequestDTO(
    @NotNull
    var email: String,
    @NotNull
    var password: String
)
