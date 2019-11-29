package com.sdvstark.vintagemovie.util.abstraction

interface JsonParser {
    fun <T> fromJson(json: String, classInfo: Class<T>): T
    fun <T> toJson(model: T, classInfo: Class<T>): String
}