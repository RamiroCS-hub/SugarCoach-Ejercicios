package com.example.primerejercicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fizzBuzz()
    }
    private fun fizzBuzz(){
        for (i in 1..100){
            if(i%3 == 0 && i%5 == 0){
                println("fizzBuzz")
                continue
            }
            if( i%3 == 0){
                println("fizz")
                continue
            }
            if( i%5 == 0){
                println("buzz")
                continue
            }
            println(i)

        }
    }
}