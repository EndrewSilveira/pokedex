package com.example.pokedex2.screen.home

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val pokedexModule = module {
    viewModel { PokedexViewModel(get()) }
    factory<PokedexContract.Repository> { PokedexRepository(get()) }
}