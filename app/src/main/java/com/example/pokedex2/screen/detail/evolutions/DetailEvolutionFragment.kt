package com.example.pokedex2.screen.detail.evolutions

import androidx.core.os.bundleOf
import com.bumptech.glide.Glide
import com.example.pokedex2.R
import com.example.pokedex2.base.BaseFragment
import com.example.pokedex2.domain.Pokemon
import com.example.pokedex2.screen.detail.DetailFragment.Companion.ARG_POKEMON
import kotlinx.android.synthetic.main.fragment_detail_evolutions.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.module.Module

class DetailEvolutionFragment: BaseFragment() {

    companion object {
        fun newInstance(
            pokemon: Pokemon
        ):DetailEvolutionFragment {
            return DetailEvolutionFragment().apply {
                this.arguments = bundleOf(ARG_POKEMON to pokemon)
            }
        }
    }

    override val module: Module = evolutionModule
    override val screenLayout = R.layout.fragment_detail_evolutions
    override val viewModel: EvolutionViewModel by viewModel()
    private var chainList = mutableListOf<Pokemon>()

    override fun initView() {

    }

    override fun initObservers() {
        val pokeArgs = arguments?.getParcelable<Pokemon>(ARG_POKEMON)

        viewModel.evolutionChain.observe(this, {

            viewModel.getPokemonByName(it.chain.species?.name!!)

            viewModel.chain.observe(this,{chain->
//                chainList.addAll(chain)
//                when(chainList.size){
//                    1 -> {viewModel.getPokemonByName(it.chain.evolvesTo[0].species?.name!!)}
//                    2 -> {viewModel.getPokemonByName(it.chain.evolvesTo[0].evolvesTo[0].species?.name!!)}
//                }
            })

        })
        viewModel.secondEvolutionByName.observe(this, {})
    }

    override fun onFetchInitial() {
        viewModel.getPokemonSpecie(arguments?.getParcelable<Pokemon>(ARG_POKEMON)?.number!!)
    }
}