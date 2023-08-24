package com.example.probandoavd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    enum class DogRace{
        DOBERMAN, CHIHUAHUA, GOLDEN, CANICHE;
    }
    private fun enumTest(){
        var myDog: DogRace = DogRace.GOLDEN
        println("Nombre de propiedad: $myDog.name")
        println("Ordinal del enum: $myDog.ordinal")
    }
}