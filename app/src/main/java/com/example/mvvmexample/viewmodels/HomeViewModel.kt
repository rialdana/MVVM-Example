package com.example.mvvmexample.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel(){

    private val _numbersList = MutableLiveData<List<Int>>()

    val numbersList : LiveData<List<Int>>
        get() = _numbersList

    init {
        _numbersList.value = listOf(1, 2, 3, 4)
    }

    fun setNewList(list: List<Int>){
        _numbersList.value = list
    }
}