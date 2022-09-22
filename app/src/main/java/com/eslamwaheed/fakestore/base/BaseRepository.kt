package com.eslamwaheed.fakestore.base

import com.eslamwaheed.fakestore.api.NetworkResult
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

abstract class BaseRepository {
    suspend fun <T> safeApiCall(apiToBeCalled: suspend () -> Response<T>): NetworkResult<T> {
        return withContext(IO) {
            try {
                val response: Response<T> = apiToBeCalled()
                if (response.isSuccessful) {
                    NetworkResult.Success(data = response.body()!!)
                } else {
                    NetworkResult.Error(errorMessage = "Something went wrong")
                }
            } catch (e: HttpException) {
                NetworkResult.Error(errorMessage = e.message ?: "Something went wrong")
            } catch (e: IOException) {
                NetworkResult.Error("Please check your network connection")
            } catch (e: Exception) {
                NetworkResult.Error(errorMessage = "Something went wrong")
            }
        }
    }
}