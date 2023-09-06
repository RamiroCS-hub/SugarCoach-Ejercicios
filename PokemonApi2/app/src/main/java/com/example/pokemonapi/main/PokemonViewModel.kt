package com.example.pokemonapi.main

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PokemonViewModel(
    private val repository: PokemonRepository = PokemonRepository(PokemonApi.instance) // Crear una instancia de la API
): ViewModel() {
    var state by mutableStateOf(MainState())
        private set
    init {
        viewModelScope.launch{
            state = state.copy( isLoading = true )
            delay(2000)
            repository.getPokemon().onSuccess {
                Log.i("OnSucces:", "${it}")
                state = state.copy(
                    pokemon = it
                )
            }.onFailure {
                Log.i("OnFailure", "${it}")
            }
            state = state.copy( isLoading = false )
        }
    }
}