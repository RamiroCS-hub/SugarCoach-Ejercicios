package com.example.chinesehoroscope

data class PokemonResponse(
    val abilities: List<Ability>,
    val base_experience: Int,
    val forms: List<Form>
)