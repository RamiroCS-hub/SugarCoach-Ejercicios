package com.example.robot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.TranslateAnimation
import android.widget.ImageView
import androidx.core.view.ViewCompat.getX

class MainActivity : AppCompatActivity() {
    var imgRobot: ImageView? = null
    var posY: Float? = null
    var posX: Float? = null
    var mapOfInstructions: MutableMap<String, Float> = mutableMapOf()
    var numberOfInstructions: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imgRobot = findViewById(R.id.imgRobot)
        posY = imgRobot?.y
        posX = imgRobot?.x
    }
    fun executeInstructions(view: View){
        restartRobot()
        mapOfInstructions.forEach{
            if( it.key.contains('y') ){
                println("Instruccion ${it.key}")
                moveRobot(posToY = 10F, execution = true)
            }else{
                println("Instruccion ${it.key}")
                //moveRobot(posToX = it.value, execution = true)
            }
        }
    }
    fun controlRobot(view: View){
        val defaultDistance: Float = 75F
        when(view.id){
            R.id.btnDown -> {
                println("La posición es: ${posY}")
                moveRobot(posToY = defaultDistance, execution = false)
            }
            R.id.btnUp -> {
                println("La posición es: ${posY}")
                moveRobot(posToY = -defaultDistance, execution = false)
            }
            R.id.btnLeft -> {
                println("La posición es: ${posY}")
                moveRobot(posToX = -defaultDistance, execution = false)
            }
            R.id.btnRight -> {
                println("La posición es: ${posY}")
                moveRobot(posToX = defaultDistance, execution = false)
            }
        }
    }
    private fun moveRobot(posToX:Float = 0F, posToY:Float = 0F, execution:Boolean){
        val animation = TranslateAnimation(posX!!, posX!! + posToX, posY!!, posY!! + posToY)
        println("execution es: $execution")
        if(!execution){
            if(posToY != 0F) {
                posY = posY!! + posToY
                mapOfInstructions.put("Y${numberOfInstructions}", posToY)
            }else {
                posX = posX!! + posToX
                mapOfInstructions.put("X${numberOfInstructions}", posToX)
            }
        }else{
            if(posToY != 0F) {
                println("Movimiento robot en ejecución")
                posY = posY!! + posToY
            }else {
                println("Movimiento robot en ejecución")
                posX = posX!! + posToX
            }
        }
        numberOfInstructions += 1
        animation.duration = 150
        animation.fillAfter = true
        imgRobot?.startAnimation(animation)
    }

    private fun restartRobot(){
        val animation = TranslateAnimation(posX!!, 0F, posY!!, 0F)
        posX = 0F
        posY = 0F
        animation.duration = 150
        animation.fillAfter = true
        imgRobot?.startAnimation(animation)
    }
}