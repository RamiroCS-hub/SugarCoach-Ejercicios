package com.example.batallapokemon

import java.io.Serializable

class pokemon(type:String, attack:Int, defense:Int): Serializable {
    var type:String
    var attack:Int
    var defense:Int
    var typeList: MutableList<String> = mutableListOf("fire", "water", "plant", "electric")
    var mapOfMultipliers: Map<String,Double> = mutableMapOf()
    init {
        this.type = type
        this.attack = attack
        this.defense = defense
        this.typeList.removeAll {
            it == this.type
        }
        this.getMultiplier()
    }
    fun getSrc():String{
        when(type){
            "water" -> return "squirtle"
            "fire" -> return "infernape"
            "plant" -> return "bulbasur"
            "electric" -> return "pikachu"
        }
        return ""
    }
    fun defense(attacker: pokemon): String{
        val attackMultiplier = mapOfMultipliers[attacker.type]
        val dammage: Double = 50 * (attacker.attack/this.defense) * attackMultiplier!!
        return "El daño fue de ${dammage} pts"
    }
    private fun getMultiplier(){
        when(this.type){
            "water" ->{
                mapOfMultipliers = mutableMapOf("electric" to 2.0, "fire" to 0.5,"plant" to 2.0)
            }
            "fire"->{
                mapOfMultipliers = mutableMapOf("electric" to 1.0, "water" to 2.0,"plant" to 0.5)
            }
            "electric"->{
                mapOfMultipliers = mutableMapOf("water" to 1.0, "fire" to 1.0,"plant" to 1.0)
            }
            "plant"->{
                mapOfMultipliers = mutableMapOf("water" to 0.5, "fire" to 2.0,"electric" to 0.5)
            }
        }
    }
}