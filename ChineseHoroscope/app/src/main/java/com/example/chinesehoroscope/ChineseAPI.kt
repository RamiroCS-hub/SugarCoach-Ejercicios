package com.example.chinesehoroscope

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.POST

interface ChineseAPI {
    companion object{
        val instance = Retrofit.Builder().baseUrl("https://api.bloom.be/api/").
        addConverterFactory(MoshiConverterFactory.create()).
        client(
            OkHttpClient.Builder().build()
        ).build().create(ChineseAPI::class.java)
    }
    @POST("chinese-horo")
    suspend fun getSign(): HoroscopeResponse
}