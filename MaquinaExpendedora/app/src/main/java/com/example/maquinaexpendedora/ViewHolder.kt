package com.example.maquinaexpendedora

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.maquinaexpendedora.databinding.ItemDrinkBinding

class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val binding = ItemDrinkBinding.bind(view)
    fun bind(drink: Drink){
        binding.txtName.text = drink.name
        binding.txtPrice.text = "${drink.price}$"
        val drinkImg = binding.imgDrink
        when(binding.txtName.text){
            "Red Bull" -> drinkImg.setImageResource(R.drawable.redbull_can)
            "Coca" -> drinkImg.setImageResource(R.drawable.coke_can)
            "Fanta" -> drinkImg.setImageResource(R.drawable.fanta_can)
            "Sprite" -> drinkImg.setImageResource(R.drawable.sprite_can)
        }
    }
}