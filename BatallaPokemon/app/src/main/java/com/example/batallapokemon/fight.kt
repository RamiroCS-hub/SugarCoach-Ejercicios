package com.example.batallapokemon

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class fight : AppCompatActivity() {
    lateinit var firstPokemon:pokemon
    lateinit var secondPokemon:pokemon
    var imgAttack:ImageView? = null
    var imgDefense:ImageView? = null
    var txtResult: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fight)
        firstPokemon = getIntent().getSerializableExtra("atacante") as pokemon
        secondPokemon = getIntent().getSerializableExtra("defensor") as pokemon
        imgAttack = findViewById(R.id.imgAttack)
        imgDefense = findViewById(R.id.imgDefense)
        txtResult = findViewById(R.id.txtResult)
        println("El first pokemon src es:${firstPokemon.getSrc()} Y el second src es:${secondPokemon.getSrc()}")
        when(firstPokemon.getSrc()){
            "squirtle" -> imgAttack?.setImageResource(R.drawable.squirtle)
            "infernape" -> imgAttack?.setImageResource(R.drawable.infernape)
            "pikachu" -> imgAttack?.setImageResource(R.drawable.pikachu)
            "bulbasur" -> imgAttack?.setImageResource(R.drawable.bulbasur)
        }

        when(secondPokemon.getSrc()){
            "squirtle" -> imgDefense?.setImageResource(R.drawable.squirtle)
            "infernape" -> imgDefense?.setImageResource(R.drawable.infernape)
            "pikachu" -> imgDefense?.setImageResource(R.drawable.pikachu)
            "bulbasur" -> imgDefense?.setImageResource(R.drawable.bulbasur)
        }
        attack()
    }
    private fun attack(){
        var dammage:String = secondPokemon.defense(firstPokemon)
        when(secondPokemon.mapOfMultipliers[firstPokemon.type]){
            1.0 -> dammage += ". El ataque fue neutral"
            2.0 -> dammage += ". El ataque fue superefectivo"
            0.5 -> dammage += ". El ataque no fue muy efectivo"
        }
        txtResult?.text = dammage
    }
}