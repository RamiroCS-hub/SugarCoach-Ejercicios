package com.example.pokemonapi.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun MainScreen(viewModel: PokemonViewModel){
    val state = viewModel.state

    if(state.isLoading){
        println("Esta cargando")
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            CircularProgressIndicator()
        }
    }

    if(state.pokemon.isNotEmpty()){
        println("Cargo")
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            println(state.pokemon)
            items(state.pokemon) {
                Text(text = it.name)
            }
        }
    }
}