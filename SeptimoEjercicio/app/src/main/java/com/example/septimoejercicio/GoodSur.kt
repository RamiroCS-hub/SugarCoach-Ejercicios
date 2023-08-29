package com.example.septimoejercicio

class GoodSur(newCant: Int): GoodRace(), Race {

    override var cant: Int = newCant

    override val attackPower: Int = 2

    override val raceIdent: Boolean = super.raceIdent
}