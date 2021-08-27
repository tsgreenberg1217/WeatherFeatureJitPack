package com.example.weatherapplibrary.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

enum class HEADER { ONE, TWO }
class HeadersViewModel : ViewModel(){
    val highlightedHeader: MutableLiveData<HEADER> by lazy { MutableLiveData(HEADER.ONE) }
    fun navigateToHeader(header: HEADER) {
        highlightedHeader.value = header
    }
}