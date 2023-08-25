package com.example.kotlinsegundovideo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //enumTest()
        //classTest()
        interfaceTest()
    }
    enum class DogRace{
        DOBERMAN, CHIHUAHUA, GOLDEN, CANICHE;
    }

    private fun enumTest(){
        val myDog: DogRace = DogRace.GOLDEN
        println("Nombre de propiedad: ${myDog.name}")
        println("Ordinal del enum: ${myDog.ordinal}")
    }

    private fun classTest(){
        val myClass = MyFirstClass("Jorge")
        val myHeritanceClass = MySecondClass("Roberto")
        myClass.message()
        myHeritanceClass.message()
    }
    /* EJERCICIO 24/08/23 */
    private fun interfaceTest(){
        val mySecondClass = MySecondClass("XXXX")
        mySecondClass.intVar = "Variable de interfaz"
        println(mySecondClass.intVar)
        //println(mySecondClass.intFun())
        mySecondClass.intVar = "Variable de interfaz modificada"
        println(mySecondClass.intVar)
    }
}