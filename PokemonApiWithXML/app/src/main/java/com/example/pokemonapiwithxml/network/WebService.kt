package com.example.pokemonapiwithxml.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface WebService {
    @GET("{pokemon}")
    suspend fun getPokemon(
        @Path("pokemon") pokemon: String
    ): Response<PokemonResponse>
}