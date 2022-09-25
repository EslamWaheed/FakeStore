package com.eslamwaheed.fakestore.models.responses

import android.os.Parcelable
import com.eslamwaheed.fakestore.models.entities.ProductsResponseItem
import kotlinx.parcelize.Parcelize

@Parcelize
class ProductsResponse : ArrayList<ProductsResponseItem?>(), Parcelable
