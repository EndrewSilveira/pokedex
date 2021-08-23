package com.example.pokedex2.screen.home

import android.os.Build
import android.view.MenuItem
import android.view.View
import android.view.WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokedex2.R
import com.example.pokedex2.base.BaseFragment
import com.example.pokedex2.domain.Pokemon
import com.example.pokedex2.domain.PokemonSpecies
import com.example.pokedex2.util.extension.TransitionAnimation
import com.example.pokedex2.util.extension.hideKeyboard
import com.example.pokedex2.util.extension.navigate
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.layout_pokedex_item.*
import kotlinx.android.synthetic.main.search_bar_layout.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.module.Module
import java.util.*

class HomeFragment : BaseFragment(), NavigationView.OnNavigationItemSelectedListener {

    override val module: Module = pokedexModule
    override val screenLayout = R.layout.fragment_home
    override val viewModel: PokedexViewModel by viewModel()
    private var pokedexList = listOf<Pokemon>()
    private val favPokemon = mutableListOf<Pokemon>()

    private val mAdapter: PokedexAdapter by lazy {
        PokedexAdapter(favPokemon)
    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun initView() {
        setTheme()
        requireActivity().window.decorView.windowInsetsController?.setSystemBarsAppearance(
            APPEARANCE_LIGHT_STATUS_BARS,
            APPEARANCE_LIGHT_STATUS_BARS
        )
        onInitDrawer()

        isLoading(true)
        mAdapter.setData(pokedexList)

        ivMenuIcon.setOnClickListener {
            drawerLayout.openDrawer(nav_view)
            hideKeyboard()
        }

        etSearch.setOnEditorActionListener { _, action, _ ->
            if (action == EditorInfo.IME_ACTION_SEARCH) {
                hideKeyboard()
            }
            true
        }
        tilSearch.setEndIconOnClickListener {
            etSearch.text?.clear()
            tvEmptySearch.visibility = View.GONE
            hideKeyboard()
        }

        mAdapter.onItemClick = {
            onNavigateToDetail(it)
        }

        mAdapter.onFavorited ={
            favPokemon.add(it)
        }
        mAdapter.onFavoritedRemoved = {
            favPokemon.remove(it)
        }
//        endlessScrollListener()
    }

    override fun initObservers() {
        viewModel.pokemons.observe(this, { pokemon ->
            pokedexList = pokemon
            rvPokemons.adapter = mAdapter
            rvPokemons.layoutManager = GridLayoutManager(context, 2)
            mAdapter.setData(pokemon)
            isLoading(false)

            etSearch.doAfterTextChanged {
                if (it.isNullOrBlank()) {
                    mAdapter.setData(pokemon)
                } else {
                    val filteredPokemons = pokemon.filter { pokemons ->
                        pokemons.name.contains(it.toString(), true)
                    }
                    mAdapter.setData(filteredPokemons)
                    if (filteredPokemons.isNullOrEmpty()) {
                        tvEmptySearch.visibility = View.VISIBLE
                    } else {
                        tvEmptySearch.visibility = View.GONE
                    }
                }
            }
        })
    }

    override fun onFetchInitial() {
        viewModel.loadPokemons(50, 0)
    }

    private fun isLoading(loading: Boolean) {
        etSearch.isEnabled = !loading
        appBarLayoutPokedex.isEnabled = !loading
        rvPokemons.isNestedScrollingEnabled = !loading
        if (loading) {
            viewLockScreen.visibility = View.VISIBLE
            pbLoading.visibility = View.VISIBLE
        } else if (!loading) {
            viewLockScreen.visibility = View.GONE
            pbLoading.visibility = View.GONE
            tvEmptySearch.visibility = View.GONE
        }
    }

    // region Local
    private fun onInitDrawer() {
        nav_view.setNavigationItemSelectedListener(this)
        drawerLayout.closeDrawer(nav_view)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun setTheme() {
        requireActivity().setTheme(R.style.Theme_Pokedexandroid)
        requireActivity().window.statusBarColor = context?.getColor(R.color.whiteVariant)!!
    }

    private fun endlessScrollListener() {
        val endlessScrollListener = object : RecyclerViewScrollListener() {
            override fun onLoadMore(limit: Int, offset: Int) {
                viewModel.loadPokemons(limit, offset)
            }
        }
        rvPokemons.addOnScrollListener(endlessScrollListener)
    }
    // endRegion Local

    // region Navigation
    private fun onNavigateToDetail(pokemonQuery: Pokemon) {
        val direction = HomeFragmentDirections.actionHomeFragmentToDeailFragment(pokemonQuery)
        navigate(direction, TransitionAnimation.TRANSLATE_FROM_RIGHT)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.moves -> {
                val direction = HomeFragmentDirections.actionHomeFragmentToMovesFragment()
                navigate(direction, TransitionAnimation.TRANSLATE_FROM_RIGHT)
            }
            R.id.berries -> {
                Toast.makeText(context, "berries", Toast.LENGTH_SHORT).show()
            }
            R.id.items -> {
                Toast.makeText(context, "items", Toast.LENGTH_SHORT).show()
            }
            R.id.favorites -> {
                Toast.makeText(context, "favorites", Toast.LENGTH_SHORT).show()
            }
            R.id.options -> {
                Toast.makeText(context, "options", Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }
}