package com.example.cuartoejercicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val activity: List<String> = listOf<String>("run","run","jump")
        val track: String = "_/_"

        val resultAndActivity: Array<String> = athleteActivity(activity, track)
        println("El resultado de la carrera es: ${resultAndActivity[0]}, el track es: ${resultAndActivity[1]}")
    }
    private fun athleteActivity( activities: List<String>, tracks: String ): Array<String> {
        //Array para las actividades y las pistas que pueden existir
        val posActivities: List<String> = listOf<String>("run","jump")
        val posTracks: List<String> = listOf<String>("_","|")
        val charTrack = tracks.toCharArray()

        if(tracks.length != activities.size){
            val mesgError = "Error: Tiene que haber la misma cantidad de actividades que de caminos"
            return arrayOf<String>(mesgError, tracks)
        }

        // Compruebo si la actividad y el track existen
        if( !posActivities.containsAll(activities) || (!posTracks.any { tracks -> true }) ){
            val mesgError = "Error: La actividad puede ser 'jump' o 'run' y la pista solo '_' o '/'"
            return  arrayOf<String> (mesgError, tracks)
        }

        var posTrack:Int = 0
        activities.forEach{
            when(it){
                "run" -> {
                    charTrack[posTrack] = verifyActivity(charTrack[posTrack], '_')
                }
                "jump" -> {
                    charTrack[posTrack] = verifyActivity(charTrack[posTrack], '/')
                }
            }
            posTrack++
        }
        val result = ( !(charTrack.contains('x') || charTrack.contains('|')) ).toString()
        return (arrayOf<String> ( result, String(charTrack) ) )
    }
    private fun verifyActivity(track: Char, obstacle: Char): Char {
        if(track != obstacle){
            when(obstacle){
                '_' -> return 'x'
                '/' -> return '|'
            }
        }
        return track
    }
}