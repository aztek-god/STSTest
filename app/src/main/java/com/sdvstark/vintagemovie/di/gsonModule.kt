package com.sdvstark.vintagemovie.di

import com.google.gson.Gson
import org.koin.dsl.bind
import org.koin.dsl.module

val gsonModule = module {
    single {
        Gson()
    } bind Gson::class
}