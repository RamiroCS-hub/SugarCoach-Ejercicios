package com.example.pokemonapi.main

data class PokemonResponse(
    val base_experience: Int,
    val height: Int,
    val id: Int,
    val is_default: Boolean,
    val name: String,
    val order: Int,
    val weight: Int
)