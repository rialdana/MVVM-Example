package com.example.mvvmexample.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmexample.Person

class FormViewModel : ViewModel(){
    private val _person = MutableLiveData<Person>()

    val person: LiveData<Person>
        get() = _person

    fun updatePersonInfo(name: String, lastName: String){

        val newPerson = Person(name, lastName)

        _person.value = newPerson
    }
}