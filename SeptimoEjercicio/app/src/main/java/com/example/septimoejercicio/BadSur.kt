package com.example.septimoejercicio

class BadSur(newCant: Int): BadRace(), Race {

    override var cant: Int = newCant

    override val attackPower = 2

    override val raceIdent: Boolean = super.raceIdent

}