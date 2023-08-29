package com.example.septimoejercicio

interface Race {
    val raceIdent: Boolean
    val attackPower: Int
    var cant: Int
    fun getTotalAttack(): Int{
        return this.attackPower * this.cant
    }
}