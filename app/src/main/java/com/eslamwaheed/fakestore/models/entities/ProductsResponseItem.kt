package com.eslamwaheed.fakestore.models.entities

import com.google.gson.annotations.SerializedName

data class ProductsResponseItem(
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("price")
    val price: Double? = 0.0,
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("category")
    val category: String? = "",
    @SerializedName("image")
    val image: String? = "",
    @SerializedName("rating")
    val rating: Rating? = Rating()
)
