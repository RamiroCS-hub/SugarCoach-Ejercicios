package com.example.kotlinsegundovideo

class MySecondClass(name: String): MyFirstClass(name), MyFirstInterface {
    override fun message(){
        println("Mensaje desde la segunda clase con el nombre ${getName()}")
    }
    //Declarando la características de la interfaz
    override var intVar: String = ""
        get() = "La variable vale: ${field}" //field guarda el valor de intVar en memoria para poder referenciarla
        set(value: String) {
            println("Se cambio la variable a ${value}")
            field = value
        }

    override fun intFun(): String {
        println("Override de la función de la interfaz")
        return "Override hecho"
    }
}