package com.example.kotlinsegundovideo

open class MyFirstClass(name: String, surname: String, age: Int){

    //Declarando la características de la interfaz
    /*override var intVar: String = ""
        get() = field //field guarda el valor de intVar en memoria para poder referenciarla
        set(value: String) {
            println("Se cambio la variable a ${value}")
            field = value
        }

    override fun intFun(): String {
        println("Override de la función de la interfaz")
        return "Override hecho"*/
    }
    fun secondFun(cant: Int) {
        println("Second fun" + cant)
    }
}