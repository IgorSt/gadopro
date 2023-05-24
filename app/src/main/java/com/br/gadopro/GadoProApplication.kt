package com.br.gadopro

import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GadoProApplication : MultiDexApplication(){

    override fun onCreate() {
        super.onCreate()
    }
}