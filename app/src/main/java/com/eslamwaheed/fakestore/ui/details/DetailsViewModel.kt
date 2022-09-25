package com.eslamwaheed.fakestore.ui.details

import com.eslamwaheed.fakestore.base.BaseViewModel
import com.eslamwaheed.fakestore.repository.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val repository: ProductsRepository) :
    BaseViewModel() {
}