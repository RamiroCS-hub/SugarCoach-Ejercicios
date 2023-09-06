package com.example.pokemonapi.main

data class MainState(
    var isLoading: Boolean = false,
    var pokemon: List<PokemonResponse> = emptyList()
)
