package com.example.pokemonapi.main
import com.example.pokemonapi.main.PokemonApi
import kotlin.reflect.KCallable


class PokemonRepository(private val api: PokemonApi) {

    suspend fun getPokemon(pokemonName: String): Result<List<PokemonResponse>>{
        return try{
            val response = listOf(api.getPokemon(pokemonName))
            //val pokemonProperties: List<PokemonResponse> = ArrayList(response::class.members)
            /*pokemonProperties.forEach {
                it = response.it
            }*/
            Result.success(response)
        }catch(e: Exception){
            Result.failure(e)
        }
    }
}