package com.example.pokemonhoroscope.main

import com.example.pokemonhoroscope.main.pokemonManage.RestrictedPokemon

data class MainState(
    var isLoading: Boolean = false,
    var pokemon: RestrictedPokemon? = null
)