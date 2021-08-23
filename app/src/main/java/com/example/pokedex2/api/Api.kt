package com.example.pokedex2.api

import com.example.pokedex2.api.model.MovesApiResult
import com.example.pokedex2.api.model.PokemonApiResult
import com.example.pokedex2.api.model.PokemonSpeciesResult
import com.example.pokedex2.api.model.PokemonsApiResult
import com.example.pokedex2.domain.EvolutionChain
import com.example.pokedex2.domain.Pokemon
import com.example.pokedex2.domain.TypeWeakness
import com.example.pokedex2.domain.PokemonSpecies
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    class Factory {

        companion object {
            fun create(): Api {
                val service: ApiService

                HttpLoggingInterceptor.Level.BODY
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://pokeapi.co/api/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

//                service = retrofit.create(ApiService::class.java)
//                fun loadPokemons(limit: Int = 151): PokemonsApiResult? {
//                    val call = service.getPokedexList(limit)
//                    return call.execute().body()
//                }
//
//                fun getPokemon(number: Int): PokemonApiResult? {
//                    val call = service.getPokemon(number)
//                    return call.execute().body()
//                }

                return retrofit.create(Api::class.java)
            }
        }
    }

    @GET("pokemon")
    suspend fun getPokedexList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int): PokemonsApiResult

    @GET("pokemon/{number}")
    suspend fun getPokemon(@Path("number")number: Int): PokemonApiResult

    @GET("pokemon/{name}/")
    suspend fun getPokemonByName(@Path("name")name: String): Pokemon

    @GET("pokemon-species/{number}")
    suspend fun getPokemonSpecies(@Path("number")number: Int): PokemonSpeciesResult

    @GET("pokemon-species/{number}")
    suspend fun getPokemonSpecie(@Path("number")number: Int): PokemonSpecies

    @GET("move")
    suspend fun getMovesList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int): MovesApiResult

    @GET("type/{name}/")
    suspend fun getWeakness(@Path("name")name: String): TypeWeakness

    @GET("evolution-chain/{id}/")
    suspend fun getEvolutionChain(@Path("id")id: Int): EvolutionChain
}