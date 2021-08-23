package com.example.pokedex2.api

import com.example.pokedex2.api.model.PokemonApiResult
import com.example.pokedex2.api.model.PokemonsApiResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("pokemon")
    fun getPokedexList(@Query("limit") limit: Int): Call<PokemonsApiResult>

    @GET("pokemon/{number}")
    fun getPokemon(@Path("number")number: Int): Call<PokemonApiResult>
}