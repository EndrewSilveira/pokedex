package com.example.pokedex2.di

import com.example.pokedex2.api.Api
import com.example.pokedex2.api.apiHelper.ApiHelper
import com.example.pokedex2.api.apiHelper.ApiHelperImpl
import org.koin.dsl.module

val appModule = module {
    single<ApiHelper> { ApiHelperImpl(get()) }
    single { Api.Factory.create() }
}