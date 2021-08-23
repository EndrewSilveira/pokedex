package com.example.pokedex2.screen.detail.about

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex2.api.model.PokemonSpeciesResult
import com.example.pokedex2.domain.PokemonSpecies
import com.example.pokedex2.domain.PokemonType
import com.example.pokedex2.screen.detail.about.DetailAboutContract
import kotlinx.coroutines.launch

class DetailViewModel(
    private val repository: DetailAboutContract.Repository
) : ViewModel(), DetailAboutContract.ViewModel {

    override var pokemonSpecie = MutableLiveData<PokemonSpecies>()
    override var typeWeakness = MutableLiveData<List<PokemonType>>()
    override var pokemonSpecieResult = MutableLiveData<PokemonSpeciesResult>()

    override fun fetchSpecies(number: Int) {
        viewModelScope.launch {
            val pokemonSpecies = repository.getPokemonSpecie(number)
            pokemonSpecie.postValue(pokemonSpecies)
        }
    }

    override fun fetchWeakness(name: String) {
        viewModelScope.launch {
            val weakness = repository.getWeakness(name)
            typeWeakness.postValue(weakness.damageRelation?.doubleDamageFrom)
        }
    }
}