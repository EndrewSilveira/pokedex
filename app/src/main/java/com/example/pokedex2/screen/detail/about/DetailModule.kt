package com.example.pokedex2.screen.detail.about

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val detailModule = module {
    viewModel { DetailViewModel(get()) }
    factory<DetailAboutContract.Repository> { DetailRepository(get()) }
}