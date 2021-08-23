package com.example.pokedex2.screen.moves

import androidx.lifecycle.MutableLiveData
import com.example.pokedex2.api.model.MovesApiResult
import com.example.pokedex2.api.model.PokemonApiResult
import com.example.pokedex2.api.model.PokemonResult
import com.example.pokedex2.api.model.PokemonsApiResult
import com.example.pokedex2.domain.Moves
import com.example.pokedex2.domain.Pokemon

interface MovesFragmentContract {

    interface ViewModel {
        var moves: MutableLiveData<List<Moves>>

        suspend fun fetchMoves(limit: Int, offset: Int)
    }

    interface Repository {
        suspend fun getMovesList(limit: Int, offset: Int): MovesApiResult
    }
}