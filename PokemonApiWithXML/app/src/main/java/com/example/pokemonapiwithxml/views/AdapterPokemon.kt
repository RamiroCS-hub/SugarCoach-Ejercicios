package com.example.pokemonapiwithxml.views

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapiwithxml.R
import com.example.pokemonapiwithxml.network.PokemonResponse

class AdapterPokemon(
    val context: Context,
    var listaPokemon: List<PokemonResponse>
): RecyclerView.Adapter<AdapterPokemon.ViewHolder>() {

    class ViewHolder( itemView: View): RecyclerView.ViewHolder(itemView){
        val cvPokemon = itemView.findViewById(R.id.txtPokemon) as TextView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_pokemon, parent, false)
        return ViewHolder(vista)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = listaPokemon[0]
        holder.cvPokemon.text = pokemon.name
    }

    override fun getItemCount(): Int {
        return listaPokemon.size
    }
}