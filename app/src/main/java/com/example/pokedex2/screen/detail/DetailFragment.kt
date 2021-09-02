package com.example.pokedex2.screen.detail

import android.os.Build
import android.view.MotionEvent
import android.view.View
import android.view.WindowInsetsController
import androidx.annotation.RequiresApi
import androidx.core.view.ViewCompat
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.pokedex2.R
import com.example.pokedex2.base.BaseFragment
import com.example.pokedex2.screen.detail.about.AboutFragment
import com.example.pokedex2.screen.detail.about.DetailViewModel
import com.example.pokedex2.screen.detail.about.detailModule
import com.example.pokedex2.screen.detail.stats.BaseStatsFragment
import com.example.pokedex2.screen.detail.viewPager.DetailViewPagerAdapter
import com.example.pokedex2.util.extension.popBackStack
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.module.Module
import java.util.*

class DetailFragment: BaseFragment() {

    companion object{
        const val ARG_POKEMON = "pokemon"
        const val ARG_POKEMON_SPECIES = "pokemon-species"
    }

    override val module: Module? = null
    override val screenLayout = R.layout.fragment_detail
    override val viewModel: ViewModel? = null

    private val args : DetailFragmentArgs by navArgs()

    private val mAdapter: DetailViewPagerAdapter by lazy {
        DetailViewPagerAdapter(parentFragmentManager, lifecycle, args.pokemonQuery)
    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun initView() {
        setTheme()
        requireActivity().window.decorView.windowInsetsController?.setSystemBarsAppearance(
            WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS,
            WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
        )

        onFetchDetail()

        ivBackIcon.setOnClickListener {
            popBackStack()
        }

        ivArrowUp.setOnClickListener {
            if(mlDetailMotion.currentState == mlDetailMotion.startState) {
                mlDetailMotion.transitionToEnd()
            } else {
                mlDetailMotion.transitionToStart()
            }
            ivArrowUp.animate().setDuration(mlDetailMotion.transitionTimeMs).start()
        }
    }
    override fun initObservers() {
    }

    override fun onFetchInitial(){
        onInitPager()
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun onFetchDetail() {
        txtPokemonName.text = args.pokemonQuery.formattedName
        txtPokemonCode.text = "# ${args.pokemonQuery.formattedNumber}"
        txtType1.text = args.pokemonQuery.types[0].name.capitalize(Locale.ROOT)
        if (args.pokemonQuery.types.size > 1) {
            txtType2.isVisible = true
            txtType2.text = args.pokemonQuery.types[1].name.capitalize(Locale.ROOT)
        } else {
            txtType2.isVisible = false
        }
        context?.let {
            Glide.with(it)
                .load(args.pokemonQuery.imageUrl)
                .into(ivPokemonDetailImage)
        }
        BaseStatsFragment().arguments = args.toBundle()
        AboutFragment().arguments = args.toBundle()
        PokemonTypeDetailStyle(txtType1, clDetailBack).styleTypeSlotOne(requireContext())
    }

    // region local
    @RequiresApi(Build.VERSION_CODES.M)
    private fun setTheme(){
        requireActivity().setTheme(R.style.PokemonDetail)
        requireActivity().window.statusBarColor = context?.getColor(R.color.white)!!
    }

    private fun onInitPager() {

        viewPager.adapter = mAdapter
        viewPager.isUserInputEnabled = false

        tabLayout.addTab(tabLayout.newTab().setText("About"))
        tabLayout.addTab(tabLayout.newTab().setText("Base Status"))
        tabLayout.addTab(tabLayout.newTab().setText("Evolution"))
        tabLayout.addTab(tabLayout.newTab().setText("Moves"))

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            tabLayout.isNestedScrollingEnabled = false
            tabLayout.isScrollContainer = false
        } else {
            ViewCompat.setNestedScrollingEnabled(tabLayout, true)
        }

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })
    }
    // endregion local

}