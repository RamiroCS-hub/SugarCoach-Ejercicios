package com.example.pokemonhoroscope.main

import com.example.pokemonhoroscope.main.pokemonManage.RestrictedPokemon

data class MainState(
    var isLoading: Boolean = false,
    var pokemon: List<RestrictedPokemon> = emptyList(),
    var called: Boolean = false,
    var animal: String = ""
)