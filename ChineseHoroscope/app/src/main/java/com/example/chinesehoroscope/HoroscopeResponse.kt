package com.example.chinesehoroscope

data class HoroscopeResponse(
    val date: String,
    val intro: String,
    val name: String,
    val sign: String,
    val text: String
)