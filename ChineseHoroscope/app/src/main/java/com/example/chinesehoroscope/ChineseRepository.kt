package com.example.chinesehoroscope

import java.lang.Exception

class ChineseRepository(private val api: ChineseAPI) {

    suspend fun getHoroscope(): Result<HoroscopeResponse> {
        try{
            val response = api.getSign()
            return Result.success(response)
        }catch(e: Exception){
            return Result.failure(e)
        }

    }
}