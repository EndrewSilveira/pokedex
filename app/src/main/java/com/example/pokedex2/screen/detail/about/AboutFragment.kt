package com.example.pokedex2.screen.detail.about

import androidx.core.os.bundleOf
import com.example.pokedex2.R
import com.example.pokedex2.base.BaseFragment
import com.example.pokedex2.domain.Pokemon
import com.example.pokedex2.screen.detail.DetailFragment.Companion.ARG_POKEMON
import com.example.pokedex2.screen.detail.about.weakness.WeaknessAdapter
import kotlinx.android.synthetic.main.fragment_detail_about.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.module.Module

class AboutFragment: BaseFragment() {

    companion object {
        fun newInstance(
            pokemon: Pokemon
        ): AboutFragment {
            return AboutFragment().apply {
                this.arguments = bundleOf(ARG_POKEMON to pokemon)
            }
        }
    }

    override val module: Module = detailModule
    override val screenLayout = R.layout.fragment_detail_about
    override val viewModel:  DetailViewModel by viewModel()

    private val mAdapter: WeaknessAdapter by lazy {
        WeaknessAdapter()
    }

    override fun initView() {
        val pokemonHeight = arguments?.getParcelable<Pokemon>(ARG_POKEMON)?.height?.toDouble()?.div(10)?.toString()
        val pokemonWeight = arguments?.getParcelable<Pokemon>(ARG_POKEMON)?.weight?.toDouble()?.div(10)?.toString()

        rvWeakness.adapter = mAdapter
        rvWeakness.isNestedScrollingEnabled = false

        tvAbilitiesValue.text = arguments?.getParcelable<Pokemon>(ARG_POKEMON)?.abilities?.get(0)?.ability?.name
        tvHeightValue.text = resources.getString(R.string.meters, pokemonHeight)
        tvWeightValue.text = resources.getString(R.string.kilos, pokemonWeight)
    }

    override fun initObservers() {
        viewModel.pokemonSpecie.observe(this, {
            if (it.eggGroups.size > 1){
                tvEggGroupValue.text = it.eggGroups[1].name
            } else {
                tvEggGroupValue.text = it.eggGroups[0].name
            }
            tvPokemonDescription.text = it.flavorTextEntries[4].flavorText?.replace("\n", " ")
        })
        viewModel.typeWeakness.observe(this, {
            mAdapter.setData(it)
        })
    }

    override fun onFetchInitial() {
        viewModel.fetchSpecies(arguments?.getParcelable<Pokemon>(ARG_POKEMON)?.number!!)
        viewModel.fetchWeakness(arguments?.getParcelable<Pokemon>(ARG_POKEMON)?.types?.get(0)!!.name)
    }
}