package com.example.pokedex2.screen.moves

import com.example.pokedex2.api.apiHelper.ApiHelper
import com.example.pokedex2.api.model.MovesApiResult
import com.example.pokedex2.api.model.PokemonApiResult
import com.example.pokedex2.api.model.PokemonsApiResult
import com.example.pokedex2.screen.home.PokedexContract

open class MovesFragmentRepository(
    private val apiHelper: ApiHelper
): MovesFragmentContract.Repository {
    override suspend fun getMovesList(limit: Int, offset: Int): MovesApiResult {
        return apiHelper.getMovesList(limit, offset)
    }

}