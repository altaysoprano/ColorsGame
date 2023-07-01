package com.example.colorgame

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val selectedColor: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    fun onColorChanged(color: Int) {
        selectedColor.value = color
    }
}
