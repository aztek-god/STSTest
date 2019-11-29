package com.sdvstark.vintagemovie.di

import com.sdvstark.vintagemovie.util.abstraction.ReadKeyValueStorage
import com.sdvstark.vintagemovie.util.abstraction.SharedPreferencesStorage
import org.koin.dsl.bind
import org.koin.dsl.module

val storageModule = module {
    single {
        SharedPreferencesStorage(get())
    } bind ReadKeyValueStorage::class
}