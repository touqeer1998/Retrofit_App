package com.example.retrofitapp.api

import okhttp3.Interceptor
import okhttp3.Response

class MyInterceptor:Interceptor
{
    override fun intercept(chain: Interceptor.Chain): Response
    {
        val request=chain.request()
            .newBuilder()
            .addHeader("Context_Type","Application/json")
            .addHeader("X-platform","Android")
            .addHeader("X-Auth-Token","1234567")
            .build()
        return chain.proceed(request)
    }
}