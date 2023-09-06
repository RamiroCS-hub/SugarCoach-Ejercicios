package com.example.pokemonhoroscope.main.pokemonManage

data class PokemonResponse(
    val base_experience: Int,
    val forms: List<Form>,
    val height: Int,
    val id: Int,
    val is_default: Boolean,
    val name: String,
    val order: Int,
    val weight: Int
)