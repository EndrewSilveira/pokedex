package com.example.pokedex2

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.example.pokedex2.di.appComponent
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(appComponent)
        }
    }
}