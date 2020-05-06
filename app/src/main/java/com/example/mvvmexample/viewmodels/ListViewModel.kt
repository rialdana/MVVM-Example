package com.example.mvvmexample.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmexample.Brands

class ListViewModel : ViewModel() {

    private val _brandsList = MutableLiveData<List<Brands>>()

    val brandsList: LiveData<List<Brands>>
        get() = _brandsList

    init {
        _brandsList.value = arrayListOf(
            Brands("Nike", 1997, "Nike sells shoes to people"),
            Brands("Adidas", 1890, "We sell T-shirts"),
            Brands("Coke", 2000, "We sell coke")
        )
    }

    fun addBrandToList(name: String, year: Int, description: String) {
        val currentList = _brandsList.value!!.toMutableList()
        currentList.add(Brands(name, year, description))

        _brandsList.value = currentList
    }

    /**
     * CharacterListViewModel
     */
    /*
    private val _characterList = MutableLiveData<List<Brands>>()

    val characterList: LiveData<List<Brands>>
        get() = _characterList

    init {
        onSucces {
            _characterList.value = reponse.body()!!
        }

        onFailure {

        }
    }
    
     */
}