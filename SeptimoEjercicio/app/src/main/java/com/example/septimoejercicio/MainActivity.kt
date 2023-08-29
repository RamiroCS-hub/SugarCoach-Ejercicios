package com.example.septimoejercicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mapOfSoldiers:Map<String, Int> = mapOf(
            "Sureño bueno" to 5,
            "Enano" to 2,
            "Goblin" to 3,
            "Orc" to 3
        )
        val soldiers = createSoldiers(mapOfSoldiers)
        println( goodAgainstBad(soldiers) )
    }
    private fun createSoldiers(mapOfSoldiers: Map<String,Int>): MutableList<Race>{
        val listOfSoldiers: MutableList<Race> = mutableListOf()

        for(soldier in mapOfSoldiers){
            when(soldier.key.lowercase()){
                "sureño bueno" -> {
                    val goodSur = GoodSur(soldier.value)
                    listOfSoldiers.add(goodSur)
                }
                "enano" -> {
                    val dwarve = Dwarves(soldier.value)
                    listOfSoldiers.add(dwarve)
                }
                "goblin" -> {
                    val goblin = Goblins(soldier.value)
                    listOfSoldiers.add(goblin)
                }
                "orc" -> {
                    val orc = Orcs(soldier.value)
                    listOfSoldiers.add(orc)
                }
                else ->
                    println("Esa no es una raza permitida")
            }
        }

        return listOfSoldiers
    }
    private fun goodAgainstBad(soldiers: MutableList<Race>): String{
        var warResult: Int = 0
        soldiers.forEach {
            if(it.raceIdent){
                warResult += it.getTotalAttack()
            }else{
                warResult -= it.getTotalAttack()
            }
        }
        return if(warResult != 0) {
            if (warResult > 0) "Gano el bien" else "Gano el mal"
        }else{
            "Empate"
        }
    }
}