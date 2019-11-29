package com.sdvstark.vintagemovie.util.abstraction

import android.content.SharedPreferences
import android.util.Log
import java.lang.UnsupportedOperationException

interface WriteKeyValueStorage {
    infix fun String.write(value: String)
    infix fun String.write(value: Long)
    infix fun String.write(value: Int)
    infix fun String.write(value: Short)
    infix fun String.write(value: Byte)
    infix fun String.write(value: Double)
    infix fun String.write(value: Float)
    infix fun String.write(value: Boolean)
}

interface ReadKeyValueStorage {
    infix fun String.readWithDefault(defaultValue: String): String
    infix fun String.readWithDefault(defaultValue: Long): Long
    infix fun String.readWithDefault(defaultValue: Int): Int
    infix fun String.readWithDefault(defaultValue: Short): Short
    infix fun String.readWithDefault(defaultValue: Byte): Byte
    infix fun String.readWithDefault(defaultValue: Double): Double
    infix fun String.readWithDefault(defaultValue: Float): Float
    infix fun String.readWithDefault(defaultValue: Boolean): Boolean

    fun transaction(storage: WriteKeyValueStorage.() -> Unit, onTransactionComplete: () -> Unit)
}

interface ReadWriteKeyValueStorage : ReadKeyValueStorage, WriteKeyValueStorage

class SharedPreferencesStorage(private val mSharedPreferences: SharedPreferences) :
    ReadKeyValueStorage {

    override fun transaction(
        storage: WriteKeyValueStorage.() -> Unit,
        onTransactionComplete: () -> Unit
    ) {
        val transaction: Transaction = Transaction().apply(storage)
        val params: Map<String, Any> = transaction.params

        mSharedPreferences.registerOnSharedPreferenceChangeListener { sharedPreferences: SharedPreferences, key: String ->
            Log.d("tag", "sharedPreferences = $sharedPreferences, key = $key")
            onTransactionComplete()
        }

        mSharedPreferences.writeParamsWithSingleTransaction(params)
    }

    private fun SharedPreferences.writeParamsWithSingleTransaction(paramMap: Map<String, Any>) {
        val editor: SharedPreferences.Editor = edit().apply {
            paramMap.forEach { (key, value) ->
                when (value) {
                    is Int -> {
                        putInt(key, value)
                    }

                    is Long -> {
                        putLong(key, value)
                    }

                    is Double -> {
                        throw UnsupportedOperationException("This operation is not supported yet.")
                    }

                    is Float -> {
                        putFloat(key, value)
                    }

                    is Short -> {
                        throw UnsupportedOperationException("This operation is not supported yet.")
                    }

                    is Byte -> {
                        throw UnsupportedOperationException("This operation is not supported yet.")
                    }

                    is Boolean -> {
                        putBoolean(key, value)
                    }
                }
            }
        }



        editor.apply()
    }

    private class Transaction : WriteKeyValueStorage {

        private val keyValueMap: MutableMap<String, Any> = mutableMapOf()

        val params: Map<String, Any> get() = keyValueMap.toMap()

        override fun String.write(value: String) {
            keyValueMap[this] = value
        }

        override fun String.write(value: Long) {
            keyValueMap[this] = value
        }

        override fun String.write(value: Int) {
            keyValueMap[this] = value
        }

        override fun String.write(value: Short) {
            keyValueMap[this] = value
        }

        override fun String.write(value: Byte) {
            keyValueMap[this] = value
        }

        override fun String.write(value: Double) {
            keyValueMap[this] = value
        }

        override fun String.write(value: Float) {
            keyValueMap[this] = value
        }

        override fun String.write(value: Boolean) {
            keyValueMap[this] = value
        }
    }

    override fun String.readWithDefault(defaultValue: String): String {
        return mSharedPreferences.getString(this, defaultValue) ?: defaultValue
    }

    override fun String.readWithDefault(defaultValue: Long): Long {
        return mSharedPreferences.getLong(this, defaultValue)
    }

    override fun String.readWithDefault(defaultValue: Int): Int {
        return mSharedPreferences.getInt(this, defaultValue)
    }

    override fun String.readWithDefault(defaultValue: Short): Short {
        throw UnsupportedOperationException("This operation is not supported yet.")
    }

    override fun String.readWithDefault(defaultValue: Byte): Byte {
        throw UnsupportedOperationException("This operation is not supported yet.")
    }

    override fun String.readWithDefault(defaultValue: Double): Double {
        throw UnsupportedOperationException("This operation is not supported yet.")
    }

    override fun String.readWithDefault(defaultValue: Float): Float {
        return mSharedPreferences.getFloat(this, defaultValue)
    }

    override fun String.readWithDefault(defaultValue: Boolean): Boolean {
        return mSharedPreferences.getBoolean(this, defaultValue)
    }
}