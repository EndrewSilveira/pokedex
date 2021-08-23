package com.example.pokedex2.screen.detail.about

import androidx.lifecycle.MutableLiveData
import com.example.pokedex2.api.model.PokemonSpeciesResult
import com.example.pokedex2.domain.TypeWeakness
import com.example.pokedex2.domain.PokemonSpecies
import com.example.pokedex2.domain.PokemonType

interface DetailAboutContract {

    interface ViewModel {
        var pokemonSpecie: MutableLiveData<PokemonSpecies>
        var typeWeakness: MutableLiveData<List<PokemonType>>
        var pokemonSpecieResult: MutableLiveData<PokemonSpeciesResult>

        fun fetchSpecies(number: Int)
        fun fetchWeakness(name: String)
    }

    interface Repository{
        suspend fun getPokemonSpecies(number: Int): PokemonSpeciesResult
        suspend fun getPokemonSpecie(number: Int): PokemonSpecies
        suspend fun getWeakness(name: String): TypeWeakness
    }
}