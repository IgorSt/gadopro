package com.br.gadopro

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GadoProApplication : Application(){

    override fun onCreate() {
        super.onCreate()
    }
}