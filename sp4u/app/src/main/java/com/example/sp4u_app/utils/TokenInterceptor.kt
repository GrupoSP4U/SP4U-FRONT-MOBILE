package com.example.sp4u_app.utils

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class TokenInterceptor(val token: String?): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest: Request = chain.request().newBuilder()
            .header("Authorization", "Bearer $token")
            .build()

        return chain.proceed(newRequest)
    }
}
