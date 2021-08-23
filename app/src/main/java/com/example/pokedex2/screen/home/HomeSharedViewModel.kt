package com.example.pokedex2.screen.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeSharedViewModel : ViewModel() {
    val toOpenMenu = MutableLiveData<Boolean>()
    val menuOption = MutableLiveData<Long>()
    val sideMenuEnabled = MutableLiveData<Boolean>()
}