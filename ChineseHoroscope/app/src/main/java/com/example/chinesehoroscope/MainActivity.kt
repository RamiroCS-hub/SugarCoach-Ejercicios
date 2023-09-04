package com.example.chinesehoroscope

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val repository: ChineseRepository = ChineseRepository(ChineseAPI.instance)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GlobalScope.launch {
            println(repository.getHoroscope())
        }
    } // https://github.com/square/retrofit/tree/master/retrofit-converters/moshi
    //https://api.bloom.be/docs/1.0/api/chinese-horo#section-3
}