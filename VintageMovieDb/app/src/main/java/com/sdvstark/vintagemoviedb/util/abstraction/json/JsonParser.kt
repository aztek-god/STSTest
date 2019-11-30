package com.sdvstark.vintagemoviedb.util.abstraction.json

interface JsonParser {
    fun <T> fromJson(json: String, classInfo: Class<T>): T
    fun <T> toJson(model: T, classInfo: Class<T>): String
}