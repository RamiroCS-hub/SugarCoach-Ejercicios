package com.example.chinesehoroscope

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.bloom.be/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val consumirAPI = retrofit.create(ConsumirAPI::class.java)
}