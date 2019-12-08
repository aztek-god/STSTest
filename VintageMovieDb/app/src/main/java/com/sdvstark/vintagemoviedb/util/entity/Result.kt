package com.sdvstark.vintagemoviedb.util.entity

sealed class Result<T> {
    class Success<T>(val data: T, isLast: Boolean = false) : Result<T>()

    class Failure<T>(val error: Throwable) : Result<T>()

    class Loading<T>(val isLoading: Boolean) : Result<T>()

    object Complete : Result<Nothing>()

    object Default : Result<Nothing>()

    companion object {
        fun <T> createSuccess(data: T, isLast: Boolean): Success<T> {
            return Success(data, isLast)
        }

        fun <T> createFailure(error: Throwable): Failure<T> {
            return Failure(error)
        }

        fun <T> createLoading(isLoading: Boolean): Loading<T> {
            return Loading(isLoading)
        }

        fun <T> createComplete(): Complete {
            return Complete
        }

        fun <T> createDefault(): Default {
            return Default
        }
    }
}