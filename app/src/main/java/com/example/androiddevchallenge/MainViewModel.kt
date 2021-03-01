package com.example.androiddevchallenge

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.data.Puppy
import com.example.androiddevchallenge.data.PuppyRepository


class MainViewModel : ViewModel() {

    fun getPuppyList(): List<Puppy> {
        return PuppyRepository.puppyList
    }
    private val _name = MutableLiveData("")
    val name: LiveData<String> = _name
    private val _currentPuppy = MutableLiveData<Puppy?>()
    val currentPuppy: LiveData<Puppy?> = _currentPuppy
    fun showPuppy(puppy: Puppy) {
        _currentPuppy.value = puppy
    }

    fun closePuppy() {
        _currentPuppy.value = null
    }
}