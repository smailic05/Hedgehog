package com.example.hedgehog.ui.main

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hedgehog.retrofit.Jokes
import com.example.hedgehog.retrofit.JokesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _jokes: MutableLiveData<Jokes> =MutableLiveData<Jokes>()
    val jokes: LiveData<Jokes>
        get() = _jokes
    var webState = Bundle()
    private val _title=MutableLiveData<String>()
    val title:LiveData<String>
    get() = _title

    private val repository=JokesRepository()
    fun createRequest(numberOfJokes:Int) = viewModelScope.launch(Dispatchers.IO){
        _jokes.postValue(repository.createRequest(numberOfJokes))
    }
    fun updateActionBar(title:String){
        _title.postValue(title)
    }
}