package com.example.pokedex2.screen.detail.evolutions

import com.example.pokedex2.screen.detail.about.DetailAboutContract
import com.example.pokedex2.screen.detail.about.DetailRepository
import com.example.pokedex2.screen.detail.about.DetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val evolutionModule = module {
    viewModel { EvolutionViewModel(get()) }
    factory<EvolutionContract.Repository> { EvolutionRepository(get()) }
}