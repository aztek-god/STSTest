package com.sdvstark.vintagemoviedb.util.impl.preferenses

import android.content.SharedPreferences
import com.sdvstark.vintagemoviedb.model.preferences.MapPreferencesModel
import com.sdvstark.vintagemoviedb.util.abstraction.json.JsonParser
import com.sdvstark.vintagemoviedb.util.abstraction.preferences.Preferences

class AppPreferencesImpl(
    private val mJsonParser: JsonParser,
    private val mSharedPreferences: SharedPreferences
) : Preferences<MapPreferencesModel> {
    override fun savePreferences(model: MapPreferencesModel) {
        val json = mJsonParser.toJson(model, MapPreferencesModel::class.java)
        mSharedPreferences.edit().putString(PREF_KEY, json).apply()
    }

    override fun readPreferences(): MapPreferencesModel? {
        val json = mSharedPreferences.getString(PREF_KEY, null)

        return mJsonParser.fromJson(
            json ?: throw Preferences.PreferencesNotFoundException("This preferences not found"),
            MapPreferencesModel::class.java
        )
    }

    companion object {
        private const val PREF_KEY = "app_preferences"
    }
}