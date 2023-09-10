package com.example.robot

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.util.Timer

class MainActivity : AppCompatActivity() {
    var imgRobot: ImageView? = null
    var posY: Float? = null
    var posX: Float? = null
    var mapOfInstructions: MutableMap<String, Float> = mutableMapOf()
    var numberOfInstructions: Int = 0
    var restarted: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imgRobot = findViewById(R.id.imgRobot)
        posY = imgRobot?.y
        posX = imgRobot?.x
    }
    fun executeInstructions(view: View){
        restartRobot()
        /*mapOfInstructions.forEach{
            if( it.key.contains('y') ){
                println("Instruccion ${it.key}")
                moveRobot(posToY = it.value, execution = true)
            }else{
                println("Instruccion ${it.key}")
                moveRobot(posToX = it.value, execution = true)
            }
        }*/
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
        println("execution es: $execution")
        val animation = TranslateAnimation(posX!!, posX!! + posToX, posY!!, posY!! + posToY)

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
                println("Movimiento Y robot en ejecución")
                posY = posY!! + posToY
                println("La posicion ahora es:${posY}")
            }else {
                println("Movimiento X robot en ejecución")
                posX = posX!! + posToX
                println("La posicion ahora es:${posX}")
            }
        }
        numberOfInstructions += 1
        animation.duration = 150
        animation.fillAfter = true
        animation.setAnimationListener(object: Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {
                println("La animacion emepezó")
            }

            override fun onAnimationEnd(p0: Animation?) {
                //if(execution) Thread.sleep(1000L)
            }

            override fun onAnimationRepeat(p0: Animation?) {
                Log.i("Onrepetition", "Se repite")
            }

        })
        imgRobot?.startAnimation(animation)
        //if (execution) Thread.sleep(1000L)
    }

    private fun restartRobot(){

        val animation = TranslateAnimation(posX!!, 0F, posY!!, 0F)
        posX = 0F
        posY = 0F

        animation.duration = 150
        animation.fillAfter = true
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(p0: Animation?) {
                println("Inicio la animacion")
            }

            override fun onAnimationEnd(p0: Animation?) {
                Thread.sleep(1000L)
                mapOfInstructions.forEach{
                    println("Entro al forEach")
                    if( it.key.contains('Y') ){
                        moveRobot(posToY = it.value, execution = true)
                    }else{
                        moveRobot(posToX = it.value, execution = true)
                    }
                }
            }

            override fun onAnimationRepeat(p0: Animation?) {
            }

        })
        imgRobot?.startAnimation(animation)
    }
}