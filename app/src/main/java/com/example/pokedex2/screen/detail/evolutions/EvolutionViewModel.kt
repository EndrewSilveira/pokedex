package com.example.pokedex2.screen.detail.evolutions

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex2.domain.EvolutionChain
import com.example.pokedex2.domain.Pokemon
import com.example.pokedex2.domain.PokemonSpecies
import kotlinx.coroutines.launch

class EvolutionViewModel(
    private val repository: EvolutionContract.Repository
) : ViewModel(), EvolutionContract.ViewModel {
    override var evolutionChain = MutableLiveData<EvolutionChain>()
    override var secondEvolutionByName = MutableLiveData<Pokemon>()
    override var chain = MutableLiveData<MutableList<Pokemon>>()
    override var pokemonSpecies = MutableLiveData<PokemonSpecies>()

    override fun fetchEvolutionChain(id: Int){}

    override fun getPokemonByName(name: String) {
        viewModelScope.launch {

            val pokeByName = repository.getPokemonByName(name)
            secondEvolutionByName.postValue(pokeByName)

            val chainList = mutableListOf<Pokemon>()
            chainList.add(pokeByName)
            chain.postValue(chainList)
        }
    }

    override fun getPokemonSpecie(number: Int) {
        viewModelScope.launch {

            val pokeSpecies = repository.getPokemonSpecie(number)
            pokemonSpecies.postValue(pokeSpecies)

            val chainNumber = pokeSpecies.evolutionChain.url
                ?.replace("https://pokeapi.co/api/v2/evolution-chain/", "")
                ?.replace("/", "")?.toInt()

            val evoChain = chainNumber?.let { repository.getEvolutionChain(it) }
            evolutionChain.postValue(evoChain)

        }
    }
}