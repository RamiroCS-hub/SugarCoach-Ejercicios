package com.example.chinesehoroscope

import retrofit2.Call
import retrofit2.http.GET

interface ConsumirAPI {
    @GET("planets")
    fun getTraer(): Call<HoroscopeResponse>
}