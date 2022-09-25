package com.eslamwaheed.fakestore.models.entities

import com.google.gson.annotations.SerializedName

data class Rating(
    @SerializedName("rate")
    val rate: Double? = 0.0,
    @SerializedName("count")
    val count: Int? = 0
)