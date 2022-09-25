package com.eslamwaheed.fakestore.repository

import com.eslamwaheed.fakestore.api.FakeStoreService
import com.eslamwaheed.fakestore.api.NetworkResult
import com.eslamwaheed.fakestore.base.BaseRepository
import com.eslamwaheed.fakestore.models.responses.ProductsResponse
import javax.inject.Inject

class ProductsRepository @Inject constructor(
    private val service: FakeStoreService
) : BaseRepository() {
    suspend fun getProducts(): NetworkResult<ProductsResponse> {
        val result = safeApiCall {
            service.getProducts()
        }
        return when (result) {
            is NetworkResult.Cached -> {
                return NetworkResult.Error("Not Handle in cached")
            }
            is NetworkResult.Success<ProductsResponse> -> {
                result
            }
            else -> {
                result
            }
        }
    }
}