package com.example.pokedex2.screen.detail.moves

import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModel
import com.example.pokedex2.R
import com.example.pokedex2.base.BaseFragment
import com.example.pokedex2.domain.Pokemon
import com.example.pokedex2.screen.detail.DetailFragment
import com.example.pokedex2.screen.detail.DetailFragment.Companion.ARG_POKEMON
import com.example.pokedex2.screen.detail.evolutions.DetailEvolutionFragment
import com.example.pokedex2.screen.detail.viewPager.DetailViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_detail_moves.*
import org.koin.core.module.Module

class DetailMovesFragment: BaseFragment() {

    companion object {
        fun newInstance(
            pokemon: Pokemon
        ): DetailMovesFragment {
            return DetailMovesFragment().apply {
                this.arguments = bundleOf(ARG_POKEMON to pokemon)
            }
        }
    }

    override val module: Module? = null
    override val screenLayout = R.layout.fragment_detail_moves
    override val viewModel: ViewModel?  = null

    private val mAdapter: DetailMovesAdapter by lazy {
        DetailMovesAdapter()
    }

    override fun initView() {
        rvDetailMoves.adapter = mAdapter
        mAdapter.setData(arguments?.getParcelable<Pokemon>(ARG_POKEMON)?.moves!!)

    }

    override fun initObservers() {}

    override fun onFetchInitial() {}
}