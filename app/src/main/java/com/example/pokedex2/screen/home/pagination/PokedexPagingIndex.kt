package com.example.pokedex2.screen.home.pagination

import com.example.pokedex2.api.model.PokemonResult

//data class PokedexPagingIndex(val limit: Int, val offest: Int, val total: Int) {
//
//    fun pagingIndexing(
//        offest: Int, totalFromServer: List<PokemonResult>,
//        totalFromPagging: Int
//    ): Pair<PokedexPagingIndex?, PokedexPagingIndex?> {
//        var nextKeyOffest: Int? = offest + loadSize
//        if (offest != 0 && offest >= totalFromPagging) {
//            nextKeyOffest = null
//        }
//        var previousKeyOffest: Int? = offest
//        if (offest == 0) {
//            previousKeyOffest = null
//        }
//        val previousKey = previousKeyOffest?.let {
//            PokedexPagingIndex(limit = loadSize, offest = it, total = totalFromServer)
//        }
//        val nextKey = nextKeyOffest?.let {
//            PokedexPagingIndex(limit = loadSize, offest = it, total = totalFromServer)
//        }
//        return Pair(previousKey, nextKey)
//    }
//}
