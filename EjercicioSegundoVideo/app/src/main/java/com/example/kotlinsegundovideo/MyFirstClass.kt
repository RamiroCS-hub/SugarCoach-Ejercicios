package com.example.kotlinsegundovideo

data class MyFirstClass (var name: String, var surname: String, var age: Int) {
    open fun message () {
        println("Se ejecuta desde MyFirstClass con el nombre ${name}")
    }
}