package com.example.cuartoejercicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var activity: Array<String> = arrayOf<String>("jump")
        val trackObj = Track("_")
        println( "El resultado de la carrera fue ${athleteActivity( activity, trackObj )}"  )
    }

    private fun athleteActivity( activity: Array<String>, track: Track ): Boolean {
        //Array para las actividades y las pistas que pueden existir
        val posActivities: Array<String> = arrayOf<String>("run","jump")
        val posTracks: Array<String> = arrayOf<String>("_","|")

        if( activity.size > 1){
            println("Error: No se puede agregar mas de 1 actividad")
            return false
        }

        // Compruebo si la actividad y el track existen
        if( !posActivities.contains(activity[0]) || !posTracks.contains(track.trackValue) ){
            println("Error: La actividad puede ser 'jump' o 'run' y la pista solo '_' o '/'")
            return false
        }

        when(activity[0]){
            "run" -> {
                if( track.trackValue != "_" ) {
                    println("No se puede correr si hay vallas")
                    track.trackValue = "x"
                    return false
                }
            }
            "jump" -> {
                if (track.trackValue != "|") {
                    println("No se puede saltar en la pista de carreras")
                    track.trackValue = "/"
                    return false
                }
            }
        }

        return true
    }
}