package com.example.pokemonapiwithxml.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapiwithxml.network.PokemonResponse
import com.example.pokemonapiwithxml.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PokemonViewModel: ViewModel() {
    private var _pokemon = MutableLiveData<PokemonResponse>()
    val pokemon: LiveData<PokemonResponse> = _pokemon

    fun getPokemon() {
        viewModelScope.launch(Dispatchers.IO) {
            val reponse = RetrofitClient.webService.getPokemon("Pikachu")
            withContext(Dispatchers.Main){
                _pokemon.value = reponse.body()
            }
        }
    }
}