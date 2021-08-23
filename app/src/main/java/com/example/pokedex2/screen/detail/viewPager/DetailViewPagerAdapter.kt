package com.example.pokedex2.screen.detail.viewPager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pokedex2.api.model.PokemonSpeciesResult
import com.example.pokedex2.domain.Pokemon
import com.example.pokedex2.domain.PokemonSpecies
import com.example.pokedex2.screen.detail.about.AboutFragment
import com.example.pokedex2.screen.detail.evolutions.DetailEvolutionFragment
import com.example.pokedex2.screen.detail.moves.DetailMovesFragment
import com.example.pokedex2.screen.detail.stats.BaseStatsFragment

class DetailViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle, arguments: Pokemon) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    private val arguments = arguments

    override fun createFragment(position: Int): Fragment {
        return when(position){
            1 -> {
                BaseStatsFragment.newInstance(arguments)
            }
            2 -> {
                DetailEvolutionFragment.newInstance(arguments)
            }
            3 -> {
                DetailMovesFragment.newInstance(arguments)
            }
            else -> {
                AboutFragment.newInstance(arguments)
            }
        }
    }

    override fun getItemCount() = 4
}