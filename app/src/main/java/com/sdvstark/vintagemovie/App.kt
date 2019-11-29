package com.sdvstark.vintagemovie

import android.app.Application
import com.sdvstark.vintagemovie.di.androidModule
import com.sdvstark.vintagemovie.di.gsonModule
import com.sdvstark.vintagemovie.di.jsonParserModule
import com.sdvstark.vintagemovie.di.storageModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    gsonModule,
                    jsonParserModule,
                    storageModule,
                    androidModule
                )
            )
        }
    }
}