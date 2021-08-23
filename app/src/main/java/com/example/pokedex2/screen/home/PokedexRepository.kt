package com.example.pokedex2.screen.home

import com.example.pokedex2.api.apiHelper.ApiHelper
import com.example.pokedex2.api.model.PokemonApiResult
import com.example.pokedex2.api.model.PokemonsApiResult
open class PokedexRepository(
    private val apiHelper: ApiHelper
): PokedexContract.Repository {

    override suspend fun getPokedexList(limit: Int, offset: Int): PokemonsApiResult{
        return apiHelper.getPokedexList(limit, offset)
    }

    override suspend fun getPokemon(number: Int): PokemonApiResult {
        return apiHelper.getPokemon(number)
    }
}