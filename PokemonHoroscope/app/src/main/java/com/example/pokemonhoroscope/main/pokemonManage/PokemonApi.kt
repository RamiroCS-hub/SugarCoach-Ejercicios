package com.example.pokemonhoroscope.main.pokemonManage

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {
    companion object{
        val instance = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/pokemon/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build().create(PokemonApi::class.java)
    }
    @GET("{pokemon}")
    suspend fun getPokemon(@Path("pokemon") pokemon: String): PokemonResponse
}