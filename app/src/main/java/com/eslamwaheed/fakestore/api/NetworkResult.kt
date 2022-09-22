package com.eslamwaheed.fakestore.api

sealed class NetworkResult<out T> {
    class Success<T>(val data: T) : NetworkResult<T>()
    class Cached : NetworkResult<Nothing>()
    class Error(errorMessage: String) : NetworkResult<Nothing>()
}