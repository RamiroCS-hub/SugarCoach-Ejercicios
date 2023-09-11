package com.example.maquinaexpendedora

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val drinkName = view.findViewById<TextView>(R.id.txtName)
    private val drinkPrice = view.findViewById<TextView>(R.id.txtPrice)
    private val drinkImg = view.findViewById<ImageView>(R.id.imgDrink)

    fun bind(drink: Drink){
        drinkName.text = drink.name
        drinkPrice.text = "${drink.price}$"
        when(drink.name){
            "Red Bull" -> drinkImg.setImageResource(R.drawable.redbull_can)
            "Coca" -> drinkImg.setImageResource(R.drawable.coke_can)
            "Fanta" -> drinkImg.setImageResource(R.drawable.fanta_can)
            "Sprite" -> drinkImg.setImageResource(R.drawable.sprite_can)
        }
    }
}