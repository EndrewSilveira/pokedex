package com.example.pokedex2.screen.moves

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex2.domain.Moves
import com.example.pokedex2.screen.home.PokedexContract
import kotlinx.coroutines.launch

class MovesFragmentViewModel(
    private val repository: MovesFragmentContract.Repository
) : ViewModel(), MovesFragmentContract.ViewModel {
    override var moves = MutableLiveData<List<Moves>>()

    override suspend fun fetchMoves(limit: Int, offset: Int) {
        viewModelScope.launch {
            moves.postValue(repository.getMovesList(limit, offset).results)
        }
    }
}