package com.example.iterationmaster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iterationMaster()
    }
    fun iterationMaster(){
        //FOR
        for(i in (0..100)){
            println(i)
        }
        //WHILE
        var contr = 1
        while(contr == 0){
            println(contr)
            contr -= 1
        }
        //FOR EACH
        val array100 = Array(100) {it}
        array100.forEach { println(it) }
        
    }
}