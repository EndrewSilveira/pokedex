package com.example.pokedex2.screen.detail.moves

import androidx.lifecycle.ViewModel

class DetailMovesViewModel(
    private val repository: DetailMovesContract.Repository
) : ViewModel(), DetailMovesContract.ViewModel {
}