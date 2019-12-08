package com.sdvstark.vintagemoviedb

import android.app.Application
import com.sdvstark.vintagemoviedb.di.retrofitModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    retrofitModule
                )
            )
        }
    }
}