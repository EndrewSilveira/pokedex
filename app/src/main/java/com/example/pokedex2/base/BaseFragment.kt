package com.example.pokedex2.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.pokedex2.R
import com.example.pokedex2.util.extension.hideKeyboard
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.core.module.Module

abstract class BaseFragment : Fragment() {

    private var mScreenLayout = -1
    private var mIsLayoutCreated = false
    private var mLayoutView: View? = null
//    private var mBaseViewModel: ViewModel? = null
    private lateinit var callback: OnBackPressedCallback

    abstract val module: Module?
    abstract val screenLayout: Int
    abstract val viewModel: ViewModel?

    abstract fun initView()
    abstract fun initObservers()
    abstract fun onFetchInitial()
    open fun onSynchronized() {}
    open fun onFragmentResult(code: Int, data: Any?) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        requireActivity().setTheme(R.style.Theme_Pokedexandroid)
        loadModule()
        super.onCreate(savedInstanceState)

        mScreenLayout = screenLayout
//        mBaseViewModel = viewModel

        initObservers()

//        callback = object : OnBackPressedCallback(true) {
//            override fun handleOnBackPressed() {
//                onBackButtonPressed(this)
//            }
//        }
//        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        try {
            if (mLayoutView == null) {
                mLayoutView = inflater.inflate(
                    mScreenLayout,
                    container,
                    false
                )
            } else {
//            mIsLayoutCreated = true
                val viewGroup = mLayoutView?.parent as? ViewGroup
                viewGroup?.let {
                    it.endViewTransition(mLayoutView)
                    it.removeView(mLayoutView)
                }
            }
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
        hideKeyboard()
        return mLayoutView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!mIsLayoutCreated) {
            initView()
            onFetchInitial()
            mIsLayoutCreated = true
        }
    }

    private fun loadModule() {
        try {
            module?.let {
                unloadKoinModules(it)
                loadKoinModules(it)
            }
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
    }

    open fun onBackButtonPressed(callback: OnBackPressedCallback) {
        callback.isEnabled = false
        activity?.onBackPressed()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}