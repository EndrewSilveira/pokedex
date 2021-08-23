package com.example.pokedex2.screen.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokedex2.api.model.PokemonApiResult
import com.example.pokedex2.api.model.PokemonResult
import com.example.pokedex2.api.model.PokemonsApiResult
import com.example.pokedex2.domain.Pokemon

interface PokedexContract {

    interface ViewModel {
        var pokemonsResult: MutableLiveData<List<PokemonResult>>
        var pokemons: MutableLiveData<List<Pokemon>>

        fun loadPokemons(limit: Int, offset: Int)
    }

    interface Repository {
        suspend fun getPokedexList(limit: Int, offset: Int): PokemonsApiResult
        suspend fun getPokemon(number: Int): PokemonApiResult
    }
}