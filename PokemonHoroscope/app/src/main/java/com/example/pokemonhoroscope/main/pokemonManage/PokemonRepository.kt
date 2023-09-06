package com.example.pokemonhoroscope.main.pokemonManage

import com.example.pokemonhoroscope.main.imageManage.ImageApi
import com.example.pokemonhoroscope.main.imageManage.ImageRepository

class PokemonRepository(private val api: PokemonApi, private val apiImage: ImageRepository) {

    suspend fun getPokemon(pokemonName: String): Result<RestrictedPokemon>{
        return try {
            val response = api.getPokemon(pokemonName)
            val id = response.id
            val image = apiImage.getImage(id)
            val pokemon = mapPokemon(response.name, image)
            Result.success(pokemon)
        }catch(e: Exception){
            Result.failure(e)
        }
    }
    private fun mapPokemon(name: String, imageUrl: String): RestrictedPokemon{
        return RestrictedPokemon(name, imageUrl)
    }
}