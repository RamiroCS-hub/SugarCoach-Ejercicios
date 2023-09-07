package com.example.pokemonapiwithxml.views

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokemonapiwithxml.databinding.ActivityMainBinding
import com.example.pokemonapiwithxml.viewModels.PokemonViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: PokemonViewModel
    private lateinit var adapterPokemon: AdapterPokemon

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[PokemonViewModel::class.java]

        setupRecyclerView()

        viewModel.pokemon.observe(this) {
            adapterPokemon.listaPokemon = listOf(it)
            adapterPokemon.notifyDataSetChanged()
        }

        binding.btnCall.setOnClickListener{
            var response = viewModel.getPokemon()
            Log.i("Response:", "$response")
        }
    }

    private fun setupRecyclerView(){
        val layoutManager = GridLayoutManager(this, 1)
        binding.rvPokemon.layoutManager = layoutManager
        adapterPokemon = AdapterPokemon(this, arrayListOf())
        binding.rvPokemon.adapter = adapterPokemon
    }
}