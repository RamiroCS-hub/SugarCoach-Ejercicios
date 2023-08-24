package com.example.kotlinsegundovideo

open class MyFirstClass (name: String) {
    private val name = name
    open fun message (){
        println("Se ejecuta desde MyFirstClass con el nombre ${name}")
    }
    protected fun getName(): String {
        return name
    }
}