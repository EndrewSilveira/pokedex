package com.example.pokedex2.screen.home.pagination

//import androidx.paging.Pager
//import com.example.pokedex2.api.Api
//import com.example.pokedex2.api.apiHelper.ApiHelper
//import com.example.pokedex2.api.model.PokemonApiResult
//import com.example.pokedex2.api.model.PokemonsApiResult
//import com.example.pokedex2.screen.home.PokedexContract
//import com.example.pokedex2.screen.home.PokedexRepository

//const val PAGE_SIZE = 20

//class PokedexRemoteDataSourceImpl(
//    private val Api: Api, apiHelper: ApiHelper
//) : PokedexRepository(apiHelper) {
//
//    override fun getMovies(): Flow<PagingData<MovieResponse>> {
//        return Pager(
//            config = PagingConfig(
//                pageSize = NETWORK_PAGE_SIZE,
//                enablePlaceholders = false
//            ),
//            pagingSourceFactory = {
//                MoviesPagingSource(service = Api)
//            }
//        ).flow
//    }
//}
