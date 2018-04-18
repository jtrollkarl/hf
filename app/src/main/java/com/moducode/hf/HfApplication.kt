package com.moducode.hf

import android.app.Application
import timber.log.Timber

class HfApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}