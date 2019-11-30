package com.sdvstark.vintagemoviedb.util.impl.json

import com.google.gson.Gson
import com.sdvstark.vintagemoviedb.util.abstraction.json.JsonParser

class GsonJsonParser(private val mGson: Gson) : JsonParser {
    override fun <T> fromJson(json: String, classInfo: Class<T>): T {
        return mGson.fromJson(json, classInfo)
    }

    override fun <T> toJson(model: T, classInfo: Class<T>): String {
        return mGson.toJson(model, classInfo)
    }
}