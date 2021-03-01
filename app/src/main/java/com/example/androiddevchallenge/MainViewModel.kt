/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
