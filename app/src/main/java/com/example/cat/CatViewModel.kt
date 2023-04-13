package com.example.cat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cat.data.CatRepository
import com.example.cat.model.CatBreed
import kotlinx.coroutines.launch


class CatViewModel: ViewModel() {
    private val repository = CatRepository()

    private val _breeds = MutableLiveData<List<CatBreed>>()
    val breeds: LiveData<List<CatBreed>> = _breeds

    fun loadBreeds() {
        viewModelScope.launch {
            _breeds.value = repository.getBreeds()
        }
    }

}