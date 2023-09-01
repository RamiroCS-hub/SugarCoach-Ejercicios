package com.example.batallapokemon

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import java.io.Serializable

open class MainActivity : AppCompatActivity() {
    var btnSquirtle:ImageButton? = null
    var btnInfernape:ImageButton? = null
    var btnBulbasur:ImageButton? = null
    var btnPikachu:ImageButton? = null
    var firstPokemon:pokemon? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSquirtle = findViewById(R.id.btnSquirtle)
        btnInfernape = findViewById(R.id.btnInfernape)
        btnBulbasur = findViewById(R.id.btnBulbasur)
        btnPikachu = findViewById(R.id.btnPikachu)
    }
    fun changeView(view: View){
        if(firstPokemon != null) {
            val intent = Intent(this, secondPokemon::class.java).apply { }
            intent.putExtra("atacante", firstPokemon)
            startActivity(intent)
        }else{
            println("No se eligió un pokemon")
        }
    }
    fun getFirstPokemon(view:View){
        when(view.id){
            R.id.btnSquirtle -> {
                println("Squirtle")
                firstPokemon = pokemon("water",20,30)
                changeBackCol(btnSquirtle,btnInfernape,btnBulbasur,btnPikachu)
            }
            R.id.btnInfernape -> {
                println("Infernape")
                firstPokemon = pokemon("fire",50,10)
                changeBackCol(btnInfernape,btnBulbasur,btnPikachu,btnSquirtle)
            }
            R.id.btnBulbasur -> {
                println("Bulbasur")
                firstPokemon = pokemon("plant",50,10)
                changeBackCol(btnBulbasur,btnPikachu,btnInfernape,btnSquirtle)
            }
            R.id.btnPikachu -> {
                println("Pikachu")
                firstPokemon = pokemon("electric",50,10)
                changeBackCol(btnPikachu,btnSquirtle,btnBulbasur,btnInfernape)
            }
        }
    }
    private fun changeBackCol(vararg objs:ImageButton?){
        for (obj in objs){
            if(objs.indexOf(obj) == 0){
                obj?.backgroundTintList = ColorStateList.valueOf(Color.RED)
                continue
            }
            obj?.backgroundTintList = ColorStateList.valueOf(Color.WHITE)
        }
    }
}