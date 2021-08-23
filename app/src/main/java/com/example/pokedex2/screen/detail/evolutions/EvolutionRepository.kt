package com.example.pokedex2.screen.detail.evolutions

import com.example.pokedex2.api.apiHelper.ApiHelper
import com.example.pokedex2.domain.EvolutionChain
import com.example.pokedex2.domain.Pokemon
import com.example.pokedex2.domain.PokemonSpecies
import com.example.pokedex2.screen.detail.about.DetailAboutContract

class EvolutionRepository(
    private val apiHelper: ApiHelper
): EvolutionContract.Repository  {
    override suspend fun getEvolutionChain(id: Int): EvolutionChain {
        return apiHelper.getEvolutionChain(id)
    }

    override suspend fun getPokemonSpecie(number: Int): PokemonSpecies {
        return apiHelper.getPokemonSpecie(number)
    }

    override suspend fun getPokemonByName(name: String): Pokemon {
        return apiHelper.getPokemonByName(name)
    }
}