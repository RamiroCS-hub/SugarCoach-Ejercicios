package com.example.septimoejercicio

class Dwarves(newCant: Int): GoodRace(), Race {

    override var cant: Int = newCant

    override val attackPower: Int = 3

    override val raceIdent: Boolean = super.raceIdent

}