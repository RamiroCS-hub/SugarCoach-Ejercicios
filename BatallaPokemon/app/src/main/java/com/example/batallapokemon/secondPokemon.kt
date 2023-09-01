package com.example.batallapokemon


import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class secondPokemon : AppCompatActivity() {
    var btnSquirtle:ImageButton? = null
    var btnInfernape:ImageButton? = null
    var btnBulbasur:ImageButton? = null
    var btnPikachu:ImageButton? = null
    var firstPokemon:pokemon? = null
    var secondPokemon:pokemon? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_pokemon)
        firstPokemon = getIntent().getSerializableExtra("atacante") as pokemon?
        btnSquirtle = findViewById(R.id.btnSquirtle2)
        btnInfernape = findViewById(R.id.btnInfernape2)
        btnBulbasur = findViewById(R.id.btnBulbasur2)
        btnPikachu = findViewById(R.id.btnPikachu2)

        when(firstPokemon?.type){
            "water" -> btnSquirtle?.visibility = View.GONE
            "fire" -> btnInfernape?.visibility = View.GONE
            "plant" -> btnBulbasur?.visibility = View.GONE
            "electric" -> btnPikachu?.visibility = View.GONE
        }
    }
    fun goToFight(view: View){
        val intent = Intent(this, fight::class.java).apply{}
        intent.putExtra("atacante", firstPokemon)
        intent.putExtra("defensor", secondPokemon)
        startActivity(intent)
    }
    fun getSecondPokemon(view:View){
        when(view.id){
            R.id.btnSquirtle2 -> {
                println("Squirtle")
                secondPokemon = pokemon("water", 20, 30)
                changeBackCol(btnSquirtle,btnInfernape,btnBulbasur,btnPikachu)
            }
            R.id.btnInfernape2 -> {
                println("Infernape")
                secondPokemon = pokemon("fire",50,10)
                changeBackCol(btnInfernape,btnSquirtle,btnBulbasur,btnPikachu)
            }
            R.id.btnBulbasur2 -> {
                println("Bulbasur")
                firstPokemon = pokemon("plant",50,10)
                changeBackCol(btnBulbasur,btnPikachu,btnInfernape,btnSquirtle)
            }
            R.id.btnPikachu2 -> {
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