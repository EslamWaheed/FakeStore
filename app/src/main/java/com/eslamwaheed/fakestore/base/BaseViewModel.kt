package com.eslamwaheed.fakestore.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eslamwaheed.fakestore.util.Event

open class BaseViewModel : ViewModel() {
    var isLoading = MutableLiveData<Event<Boolean>>()

    var showDialog = MutableLiveData<Event<String>>()
}