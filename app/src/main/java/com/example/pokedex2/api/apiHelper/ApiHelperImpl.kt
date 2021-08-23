package com.example.pokedex2.api.apiHelper

import com.example.pokedex2.api.Api
import com.example.pokedex2.api.model.MovesApiResult
import com.example.pokedex2.api.model.PokemonApiResult
import com.example.pokedex2.api.model.PokemonSpeciesResult
import com.example.pokedex2.api.model.PokemonsApiResult
import com.example.pokedex2.domain.EvolutionChain
import com.example.pokedex2.domain.Pokemon
import com.example.pokedex2.domain.TypeWeakness
import com.example.pokedex2.domain.PokemonSpecies

class ApiHelperImpl(private val api: Api) : ApiHelper {

    override suspend fun getPokedexList(limit: Int, offset: Int): PokemonsApiResult {
        return api.getPokedexList(limit, offset)
    }

    override suspend fun getPokemon(number: Int): PokemonApiResult {
        return api.getPokemon(number)
    }

    override suspend fun getPokemonSpecies(number: Int): PokemonSpeciesResult {
        return api.getPokemonSpecies(number)
    }

    override suspend fun getPokemonSpecie(number: Int): PokemonSpecies {
        return api.getPokemonSpecie(number)
    }

    override suspend fun getMovesList(limit: Int, offset: Int): MovesApiResult {
        return api.getMovesList(limit, offset)
    }

    override suspend fun getWeakness(name: String): TypeWeakness {
        return api.getWeakness(name)
    }

    override suspend fun getEvolutionChain(id: Int): EvolutionChain {
        return api.getEvolutionChain(id)
    }

    override suspend fun getPokemonByName(name: String): Pokemon {
        return api.getPokemonByName(name)
    }
}