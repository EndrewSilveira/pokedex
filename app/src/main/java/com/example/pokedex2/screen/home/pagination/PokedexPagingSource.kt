package com.example.pokedex2.screen.home.pagination
//
//import androidx.paging.PagingSource
//import androidx.paging.PagingState
//import com.example.pokedex2.api.Api
//import com.example.pokedex2.api.model.PokemonResult
//import com.example.pokedex2.api.model.PokemonsApiResult
//import retrofit2.HttpException
//import java.io.IOException

//const val loadSize = 10
//private val INTIAL_POKEDEX_PAGE_INDEX = PokedexPagingIndex(limit = loadSize,offest = 0,total = 0)
//
//class PokedexPagingSource(
//    private val api: Api
//): PagingSource<PokedexPagingIndex, PokemonResult>() {
//
//    override suspend fun load(params: LoadParams<PokedexPagingIndex>): LoadResult<PokedexPagingIndex, PokemonResult> {
//        val limit = params.key?.limit ?: INTIAL_POKEDEX_PAGE_INDEX.limit
//        val offest = params.key?.offest ?: INTIAL_POKEDEX_PAGE_INDEX.offest
//
////            val response = api.getPokedexList(
////                limit = 20,
////                offset = pageIndex
////            )
////            val pokemons = response.results
////            val nextKey =
////                if (pokemons.isEmpty()) {
////                    null
////                } else {
////                    // By default, initial load size = 3 * NETWORK PAGE SIZE
////                    // ensure we're not requesting duplicating items at the 2nd request
////                    pageIndex + (params.loadSize / PAGE_SIZE)
////                }
////            LoadResult.Page(
////                data = pokemons,
////                prevKey = if (pageIndex == STARTING_OFFSET) null else pageIndex,
////                nextKey = nextKey
////            )
//        return try {
//
//            val response = api.getPokedexList(limit, offest)
//            val pokemons = response.results
//
//            val (previousKey, nextKey) = INTIAL_POKEDEX_PAGE_INDEX.pagingIndexing(offest = offest,
//                totalFromServer = response.results,
//                totalFromPagging = params.key?.total?:0)
//
//            LoadResult.Page(
//                data = pokemons,
//                prevKey = previousKey,
//                nextKey =nextKey
//            )
//
//        } catch (exception: IOException) {
//            return LoadResult.Error(exception)
//        } catch (exception: HttpException) {
//            return LoadResult.Error(exception)
//        }
//    }
//
//    override fun getRefreshKey(state: PagingState<PokedexPagingIndex, PokemonResult>): PokedexPagingIndex? {
//
//    }
//}