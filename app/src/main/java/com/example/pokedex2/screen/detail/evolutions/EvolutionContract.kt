package com.example.pokedex2.screen.detail.evolutions

import androidx.lifecycle.MutableLiveData
import com.example.pokedex2.api.model.PokemonSpeciesResult
import com.example.pokedex2.domain.*

interface EvolutionContract {

    interface ViewModel {
        var evolutionChain: MutableLiveData<EvolutionChain>
        var secondEvolutionByName: MutableLiveData<Pokemon>
        var chain: MutableLiveData<MutableList<Pokemon>>
        var pokemonSpecies: MutableLiveData<PokemonSpecies>

        fun fetchEvolutionChain(id: Int)
        fun getPokemonByName(name: String)
        fun getPokemonSpecie(number: Int)
    }

    interface Repository{
        suspend fun getEvolutionChain(id: Int): EvolutionChain
        suspend fun getPokemonSpecie(number: Int): PokemonSpecies
        suspend fun getPokemonByName(name: String): Pokemon
    }
}