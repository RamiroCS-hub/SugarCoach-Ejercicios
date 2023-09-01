package com.example.batallapokemon

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class fight : AppCompatActivity() {
    var firstPokemon:pokemon? = null
    var secondPokemon:pokemon? = null
    var imgAttack:ImageView? = null
    var imgDefense:ImageView? = null
    var txtResult: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fight)
        firstPokemon = getIntent().getSerializableExtra("atacante") as pokemon?
        secondPokemon = getIntent().getSerializableExtra("defensor") as pokemon?
        imgAttack = findViewById(R.id.imgAttack)
        imgDefense = findViewById(R.id.imgDefense)
        txtResult = findViewById(R.id.txtResult)
        when(firstPokemon?.getSrc()){
            "squirtle" -> imgAttack?.setImageResource(R.drawable.squirtle)
            "infernape" -> imgAttack?.setImageResource(R.drawable.infernape)
            "pikachu" -> imgDefense?.setImageResource(R.drawable.pikachu)
            "bulbasur" -> imgDefense?.setImageResource(R.drawable.bulbasur)
        }

        when(secondPokemon?.getSrc()){
            "squirtle" -> imgAttack?.setImageResource(R.drawable.squirtle)
            "infernape" -> imgAttack?.setImageResource(R.drawable.infernape)
            "pikachu" -> imgDefense?.setImageResource(R.drawable.pikachu)
            "bulbasur" -> imgDefense?.setImageResource(R.drawable.bulbasur)
        }
        attack()
    }
    private fun attack(){
        secondPokemon?.defense(firstPokemon)
        txtResult?.text = "Se realizo el ataque"
    }
}