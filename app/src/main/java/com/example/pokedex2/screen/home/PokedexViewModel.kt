package com.example.pokedex2.screen.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex2.api.model.PokemonResult
import com.example.pokedex2.domain.Pokemon
import kotlinx.coroutines.launch

class PokedexViewModel(
    private val repository: PokedexContract.Repository
) : ViewModel(), PokedexContract.ViewModel {

    override var pokemonsResult = MutableLiveData<List<PokemonResult>>()
    override var pokemons = MutableLiveData<List<Pokemon>>()

    override fun loadPokemons(limit: Int, offset: Int) {
        viewModelScope.launch {
            val pokemonsApiResult = repository.getPokedexList(limit, offset)

            pokemonsApiResult.results.let {
                pokemons.postValue(it.map { pokemonResult ->

                    val number = pokemonResult.url
                        .replace("https://pokeapi.co/api/v2/pokemon/", "")
                        .replace("/", "").toInt()

                    val pokemonApiResult = repository.getPokemon(number)

                    Pokemon(
                        pokemonApiResult.id,
                        pokemonApiResult.name,
                        pokemonApiResult.height,
                        pokemonApiResult.weight,
                        pokemonApiResult.stats,
                        pokemonApiResult.abilities,
                        pokemonApiResult.moves,
                        pokemonApiResult.species,
                        pokemonApiResult.types.map { type ->
                            type.type
                        },
                        pokemonApiResult.sprites
                    )
                })
            }
        }
    }
}