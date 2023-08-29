package com.example.septimoejercicio

class Goblins(newCant: Int): BadRace(), Race {

    override var cant = newCant

    override val attackPower: Int = 2

    override val raceIdent: Boolean = super.raceIdent
}