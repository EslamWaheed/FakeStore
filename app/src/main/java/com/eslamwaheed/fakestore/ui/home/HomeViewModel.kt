package com.eslamwaheed.fakestore.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.eslamwaheed.fakestore.api.NetworkResult
import com.eslamwaheed.fakestore.base.BaseViewModel
import com.eslamwaheed.fakestore.models.responses.ProductsResponse
import com.eslamwaheed.fakestore.repository.ProductsRepository
import com.eslamwaheed.fakestore.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: ProductsRepository) :
    BaseViewModel() {

    val productsResponse: LiveData<ProductsResponse?> get() = _productsResponse
    private var _productsResponse = MutableLiveData<ProductsResponse?>()

    fun getProducts() {
        viewModelScope.launch(IO) {
            isLoading.postValue(Event(true))
            repository.getProducts().let {
                when (it) {
                    is NetworkResult.Success -> {
                        _productsResponse.postValue(it.data)
                    }
                    is NetworkResult.Cached -> {
                        //todo get cached data
                        //handled in repository
                    }
                    else -> {
                        it as NetworkResult.Error
                        showDialog.postValue(Event("Error"))
                    }
                }
            }
            isLoading.postValue(Event(false))
        }
    }
}