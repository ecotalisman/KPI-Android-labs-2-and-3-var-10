package com.learning.lab_2_var_10.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _data = MutableLiveData<String>()
    val data: LiveData<String> get() = _data

    private val _fontSize = MutableLiveData<Float>()
    val fontSize: LiveData<Float> get() = _fontSize

    fun setData(data: String) {
        _data.value = data
    }

    fun setFontSize(fontSize: Float) {
        _fontSize.value = fontSize
    }
}

