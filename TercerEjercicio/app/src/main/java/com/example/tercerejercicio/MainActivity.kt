package com.example.tercerejercicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println( areaCalculation( 30, 20) )
    }

    private fun areaCalculation( width: Int, height: Int): String{
        var squareArea:Int = width * height
        var triangleArea: Int = squareArea/2
        return "El area del cuadrado es: $squareArea, la del triángulo es: $triangleArea" +
            " y la del rectángulo es: $squareArea"



    }
}