package com.example.sextoejercicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Juego de ejemplo
        var game: List<List<String>> = listOf(
            listOf ("R","S"),
            listOf ("S","R"),
            listOf ("R","S")
        )
        println( rockPaperScisor( game ) )
    }
    private fun rockPaperScisor ( game: List<List<String>> ): String {
        var firstPlayer: Int = 0
        var secondPlayer: Int = 0

        for( array in game ) {
            
            when( array[0] ){ // Array[0] lo que saco el primer jugador Array[1] lo que saco el segundo
                "R" -> {
                    when( array[1] ){
                        "R" -> continue
                        "P" -> secondPlayer++
                        "S" -> firstPlayer++
                    }
                }
                "P" -> {
                    when( array[1] ){
                        "R" -> firstPlayer++
                        "P" -> continue
                        "S" -> secondPlayer++
                    }
                }
                "S" -> {
                    when( array[1] ){
                        "R" -> secondPlayer++
                        "P" -> firstPlayer++
                        "S" -> continue
                    }
                }
            }
        }
        if( secondPlayer > firstPlayer ){
            return "Player 2"
        }
        if( firstPlayer > secondPlayer ){
            return "Player 1"
        }
        return "tie"
    }
}