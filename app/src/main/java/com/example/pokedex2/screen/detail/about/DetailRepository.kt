package com.example.pokedex2.screen.detail.about

import com.example.pokedex2.api.apiHelper.ApiHelper
import com.example.pokedex2.api.model.PokemonSpeciesResult
import com.example.pokedex2.domain.TypeWeakness
import com.example.pokedex2.domain.PokemonSpecies

class DetailRepository(
    private val apiHelper: ApiHelper
): DetailAboutContract.Repository  {
    override suspend fun getPokemonSpecies(number: Int): PokemonSpeciesResult {
        return apiHelper.getPokemonSpecies(number)
    }

    override suspend fun getPokemonSpecie(number: Int): PokemonSpecies {
        return apiHelper.getPokemonSpecie(number)
    }

    override suspend fun getWeakness(name: String): TypeWeakness {
        return apiHelper.getWeakness(name)
    }
}