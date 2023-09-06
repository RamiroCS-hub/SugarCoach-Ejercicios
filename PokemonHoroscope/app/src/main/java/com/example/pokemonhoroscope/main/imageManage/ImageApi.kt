package com.example.pokemonhoroscope.main.imageManage

import com.example.pokemonhoroscope.main.pokemonManage.PokemonApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ImageApi {
    companion object{
        val instance = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/pokemon-form/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build().create(ImageApi::class.java)
    }
    @GET("{id}")
    suspend fun getImage(@Path("id") pokemonId: Int): ImageResponse
}