package com.example.batallapokemon

import java.io.Serializable

class pokemon(type:String, attack:Int, defense:Int): Serializable {
    var type:String
    var attack:Int
    var defense:Int
    init {
        this.type = type
        this.attack = attack
        this.defense = defense
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
    fun defense(attacker: pokemon?){
        println("El tipo del pokemon que me ataco fue: ${attacker}")
    }
}