package com.example.sp4u_app.dto.request

data class ChangePasswordRequestDTO(
    val oldPassword: String,
    val newPassword: String
)
