package com.example.pokedex2.screen.moves

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsetsController
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.example.pokedex2.R
import com.example.pokedex2.base.BaseFragment
import com.example.pokedex2.util.extension.popBackStack
import kotlinx.android.synthetic.main.fragment_moves.*
import org.koin.core.module.Module

class MovesFragment:  BaseFragment() {

    override val module: Module? = null
    override val screenLayout = R.layout.fragment_moves
    override val viewModel: ViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(screenLayout, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun initView() {
        setTheme()
        requireActivity().window.decorView.windowInsetsController?.setSystemBarsAppearance(
            WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS,
            WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
        )

        ivBackIcon.setOnClickListener {
            popBackStack()
        }
    }

    override fun initObservers() {}

    override fun onFetchInitial() {}

    @RequiresApi(Build.VERSION_CODES.M)
    private fun setTheme(){
        requireActivity().setTheme(R.style.Theme_Pokedexandroid)
        requireActivity().window.statusBarColor = context?.getColor(R.color.white)!!
    }
}