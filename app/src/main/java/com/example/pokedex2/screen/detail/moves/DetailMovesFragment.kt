package com.example.pokedex2.screen.detail.moves

import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModel
import com.example.pokedex2.R
import com.example.pokedex2.base.BaseFragment
import com.example.pokedex2.domain.Pokemon
import com.example.pokedex2.screen.detail.DetailFragment
import com.example.pokedex2.screen.detail.evolutions.DetailEvolutionFragment
import org.koin.core.module.Module

class DetailMovesFragment: BaseFragment() {

    companion object {
        fun newInstance(
            pokemon: Pokemon
        ): DetailEvolutionFragment {
            return DetailEvolutionFragment().apply {
                this.arguments = bundleOf(DetailFragment.ARG_POKEMON to pokemon)
            }
        }
    }

    override val module: Module? = null
    override val screenLayout = R.layout.fragment_detail_moves
    override val viewModel: ViewModel?  = null

    override fun initView() {}

    override fun initObservers() {}

    override fun onFetchInitial() {}
}