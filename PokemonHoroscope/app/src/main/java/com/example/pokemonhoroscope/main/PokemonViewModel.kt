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

    fun CallApi(pokemonName: String, chineseAnimal: String){
        Log.i("PokemonName:", pokemonName)
        viewModelScope.launch {

            state = state.copy(isLoading = true)

            repository.getPokemon(pokemonName.trim()).onSuccess {
                Log.i("OnSucces:", "${it.name}, ${it.imageUrl}")
                state = state.copy(pokemon = listOf(it), called = true, animal = chineseAnimal )

            }.onFailure {
                Log.i("OnFailure:", it.toString())
                state = state.copy(called = true)
            }
            state = state.copy(isLoading = false)
        }
    }

    fun getHoroscope(birthYear: Int){
        var horoscopeSign = birthYear

        while(horoscopeSign >= 1912){
            horoscopeSign -= 12
        }

        when(horoscopeSign){
            1900 -> {
                println("rata")
                CallApi("raticate", "rata")
            }
            1901 -> {
                println("buey")
                CallApi("tauros", "buey")
            }
            1902 -> {
                println("tigre")
                CallApi("incineroar", "tigre")
            }
            1903 -> {
                println("conejo")
                CallApi("scorbunny", "conejo")
            }
            1904 -> {
                println("Dragón")
                CallApi("gyarados", "dragon")
            }
            1905 -> {
                println("Serpiente")
                CallApi("ekans", "serpiente")
            }
            1906 ->{
                println("Caballo")
                CallApi("mudsdale", "caballo")
            }
            1907 -> {
                println("Cabra")
                CallApi("gogoat","cabra")
            }
            1908 -> {
                println("Mono")
                CallApi("infernape", "mono")
            }
            1909 -> {
                println("Gallo")
                CallApi("combusken", "gallo")
            }
            1910 -> {
                println("Perro")
                CallApi("rockruff", "perro")
            }
            1911 -> {
                println("chancho")
                CallApi("pignite", "chancho")
            }
            else ->{
                println("El horoscope Sign es:${horoscopeSign}")
            }
        }
    }
}
