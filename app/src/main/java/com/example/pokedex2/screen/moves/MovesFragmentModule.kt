package com.example.pokedex2.screen.moves

import com.example.pokedex2.screen.home.PokedexContract
import com.example.pokedex2.screen.home.PokedexRepository
import com.example.pokedex2.screen.home.PokedexViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val movesFragmentModule = module {
    viewModel { MovesFragmentViewModel(get()) }
    factory<MovesFragmentContract.Repository> { MovesFragmentRepository(get()) }
}
