package com.example.pokemonhoroscope.main

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonhoroscope.main.imageManage.ImageApi
import com.example.pokemonhoroscope.main.imageManage.ImageRepository
import com.example.pokemonhoroscope.main.pokemonManage.PokemonApi
import com.example.pokemonhoroscope.main.pokemonManage.PokemonRepository
import kotlinx.coroutines.launch

class PokemonViewModel(
    private val repository: PokemonRepository = PokemonRepository(
        PokemonApi.instance,
        ImageRepository(ImageApi.instance))
): ViewModel() {
    var state by mutableStateOf(MainState())
        private set

    fun CallApi(pokemonName: String){
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            repository.getPokemon(pokemonName).onSuccess {
                Log.i("OnSucces:", "${it.name}, ${it.imageUrl}")
            }.onFailure {
                Log.i("OnFailure:", it.toString())
            }
            state = state.copy(isLoading = false)
        }
    }

}
