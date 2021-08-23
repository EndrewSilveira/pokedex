package com.example.pokedex2.api.apiHelper

import com.example.pokedex2.api.model.MovesApiResult
import com.example.pokedex2.api.model.PokemonApiResult
import com.example.pokedex2.api.model.PokemonSpeciesResult
import com.example.pokedex2.api.model.PokemonsApiResult
import com.example.pokedex2.domain.EvolutionChain
import com.example.pokedex2.domain.Pokemon
import com.example.pokedex2.domain.TypeWeakness
import com.example.pokedex2.domain.PokemonSpecies

interface ApiHelper {

    suspend fun getPokedexList(limit: Int, offset: Int): PokemonsApiResult
    suspend fun getPokemon(number: Int): PokemonApiResult
    suspend fun getPokemonSpecies(number: Int): PokemonSpeciesResult
    suspend fun getPokemonSpecie(number: Int): PokemonSpecies
    suspend fun getMovesList(limit: Int, offset: Int): MovesApiResult
    suspend fun getWeakness(name: String): TypeWeakness
    suspend fun getEvolutionChain(id: Int): EvolutionChain
    suspend fun getPokemonByName(name: String): Pokemon
}