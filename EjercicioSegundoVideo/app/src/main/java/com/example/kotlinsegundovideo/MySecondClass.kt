package com.example.kotlinsegundovideo

class MySecondClass(name: String, surname: String, age: Int): MyFirstInterface {

    //Declarando la características de la interfaz
    override var intVar: String = "Sin modificar"

    override fun intFun(): String {
        println("Override de la función de la interfaz")
        return "Override hecho"
    }
    var cant:Int = 0
    fun secondFun() {
        super.secondFun(this.cant)
    }
}