package com.sdvstark.vintagemoviedb.util.abstraction.preferences

interface Preferences<T> {
    fun savePreferences(model: T)
    fun readPreferences(): T?

    class PreferencesNotFoundException(private val errorMessage: String): Exception(errorMessage)
}