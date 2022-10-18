package com.onurerdem.week_4_assignment.Interceptor

import com.onurerdem.week_4_assignment.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val apiKeyRequest = originalRequest
            .newBuilder()
            .header("X-Api-Key", BuildConfig.API_KEY)
            .build()

        return chain.proceed(apiKeyRequest)
    }
}