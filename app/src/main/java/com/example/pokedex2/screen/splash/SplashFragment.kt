package com.example.pokedex2.screen.splash

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.example.pokedex2.R
import com.example.pokedex2.base.BaseFragment
import com.example.pokedex2.util.extension.TransitionAnimation
import com.example.pokedex2.util.extension.navigate
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_splash.*
import org.koin.core.module.Module

class SplashFragment : BaseFragment() {

    companion object {
        private var TIME_ANIMATION:Long = 4000
        private var TIME_CHANGE:Long = 6000
    }

    override val module: Module? = null
    override val viewModel: ViewModel? = null
    override val screenLayout = R.layout.activity_splash

    @RequiresApi(Build.VERSION_CODES.M)
    override fun initView() {
        requireActivity().window.statusBarColor = context?.getColor(R.color.theme_red)!!
        splashAnimation()
    }

    private fun splashAnimation() {
        ivSplashIcon.animate()
            .rotation(360f)
            .withStartAction {
                ivSplashIconBack.animate().rotation(-360f).setDuration(TIME_ANIMATION).start()
            }
            .withEndAction {
                showHome()
            }
            .setDuration(TIME_ANIMATION).start()
    }

    override fun onPause() {
        super.onPause()
        ivSplashIcon.animate().cancel()
    }

    override fun onResume() {
        super.onResume()
        ivSplashIcon.animate().start()
    }

    override fun initObservers() {}
    override fun onFetchInitial() {}

    private fun showHome() {
        val direction = SplashFragmentDirections.actionSplashFragmentToHomeFragment()
        navigate(direction, TransitionAnimation.TRANSLATE_FROM_RIGHT)
    }
}