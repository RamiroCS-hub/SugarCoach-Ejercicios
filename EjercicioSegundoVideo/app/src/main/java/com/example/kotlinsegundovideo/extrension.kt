package com.example.kotlinsegundovideo

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Date.customFormat(): String{
    val formatter = SimpleDateFormat("yyyy-mm-dd'T'HH:mm:ss", Locale.getDefault())
    return formatter.format(this)
}