package com.sdvstark.vintagemovie.di

import com.google.gson.Gson
import com.sdvstark.vintagemovie.util.abstraction.JsonParser
import org.koin.dsl.bind
import org.koin.dsl.module

val jsonParserModule = module {
    single {
        GsonJsonParser(get())
    } bind JsonParser::class
}

private class GsonJsonParser(private val mGson: Gson) : JsonParser {
    override fun <T> fromJson(json: String, classInfo: Class<T>): T {
        return mGson.fromJson(json, classInfo)
    }

    override fun <T> toJson(model: T, classInfo: Class<T>): String {
        return mGson.toJson(model, classInfo)
    }
}