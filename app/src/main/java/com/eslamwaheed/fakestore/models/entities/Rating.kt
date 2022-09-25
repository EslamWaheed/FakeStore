package com.eslamwaheed.fakestore.models.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Rating(
    @SerializedName("rate")
    val rate: Float? = 0.0f,
    @SerializedName("count")
    val count: Int? = 0
) : Parcelable