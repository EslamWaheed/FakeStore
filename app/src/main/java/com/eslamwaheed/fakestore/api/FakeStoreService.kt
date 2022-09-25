package com.eslamwaheed.fakestore.api

import com.eslamwaheed.fakestore.models.responses.ProductsResponse
import retrofit2.Response
import retrofit2.http.GET

interface FakeStoreService {
    @GET("products")
    suspend fun getProducts(): Response<ProductsResponse>
}