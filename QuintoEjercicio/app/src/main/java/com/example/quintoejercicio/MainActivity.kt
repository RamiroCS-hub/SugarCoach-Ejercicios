package com.example.quintoejercicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val array1: List<Int> = arrayListOf (1,2,3,4,5,6,8,9,44,33,2221,555)
        val array2: List<Int> = arrayListOf (2,55,2221,335,7788,4,123,9,1)
        val whatReturn = false
        println(compareArray( array1, array2, whatReturn ) )
    }
    private fun compareArray( firstArray: List<Int>, secondArray: List<Int>, whatReturn: Boolean ): List<Int> {
        if (whatReturn){
            var newArray: List<Int> = firstArray.filter {
                it in secondArray
            }
            return newArray
        }
        var newArray: List<Int> = firstArray.filterNot {
            it in secondArray
        }
        return newArray
    }
}