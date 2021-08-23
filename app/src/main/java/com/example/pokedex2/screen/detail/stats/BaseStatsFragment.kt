package com.example.pokedex2.screen.detail.stats

import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.navArgs
import com.example.pokedex2.R
import com.example.pokedex2.base.BaseFragment
import com.example.pokedex2.domain.Pokemon
import com.example.pokedex2.screen.detail.DetailFragment.Companion.ARG_POKEMON
import com.example.pokedex2.screen.detail.DetailFragmentArgs
import kotlinx.android.synthetic.main.fragment_detail_base_stats.*
import org.koin.core.module.Module

class BaseStatsFragment: BaseFragment() {

    companion object {
        fun newInstance(
            args: Pokemon
        ): BaseStatsFragment{
            return BaseStatsFragment().apply {
                this.arguments = bundleOf(ARG_POKEMON to args)
            }
        }
    }

    override val module: Module? = null
    override val screenLayout = R.layout.fragment_detail_base_stats
    override val viewModel: ViewModel?  = null


    override fun initView() {
        tvStatHpValue.text = arguments?.getParcelable<Pokemon>(ARG_POKEMON)?.stats?.get(0)?.baseStat.toString()
        pbHp.progress = arguments?.getParcelable<Pokemon>(ARG_POKEMON)?.stats?.get(0)?.baseStat!!
        tvStatAttackValue.text = arguments?.getParcelable<Pokemon>(ARG_POKEMON)?.stats?.get(1)?.baseStat.toString()
        pbAttack.progress = arguments?.getParcelable<Pokemon>(ARG_POKEMON)?.stats?.get(1)?.baseStat!!
        tvStatDefenseValue.text = arguments?.getParcelable<Pokemon>(ARG_POKEMON)?.stats?.get(2)?.baseStat.toString()
        pbDefense.progress = arguments?.getParcelable<Pokemon>(ARG_POKEMON)?.stats?.get(2)?.baseStat!!
        tvStatSpAtkValue.text = arguments?.getParcelable<Pokemon>(ARG_POKEMON)?.stats?.get(3)?.baseStat.toString()
        pbSpAtk.progress = arguments?.getParcelable<Pokemon>(ARG_POKEMON)?.stats?.get(3)?.baseStat!!
        tvStatSpDefValue.text = arguments?.getParcelable<Pokemon>(ARG_POKEMON)?.stats?.get(4)?.baseStat.toString()
        pbSpDef.progress = arguments?.getParcelable<Pokemon>(ARG_POKEMON)?.stats?.get(4)?.baseStat!!
        tvStatSpeedValue.text = arguments?.getParcelable<Pokemon>(ARG_POKEMON)?.stats?.get(5)?.baseStat.toString()
        pbSpeed.progress = arguments?.getParcelable<Pokemon>(ARG_POKEMON)?.stats?.get(5)?.baseStat!!
    }

    override fun initObservers() {}

    override fun onFetchInitial() {}
}