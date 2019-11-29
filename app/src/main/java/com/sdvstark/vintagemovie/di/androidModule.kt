package com.sdvstark.vintagemovie.di

import android.content.Context
import android.content.SharedPreferences
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.bind
import org.koin.dsl.module

private const val SHARED_NAME = "shared_settings"

val androidModule = module {
    single {
        androidContext().getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE)
    } bind SharedPreferences::class
}