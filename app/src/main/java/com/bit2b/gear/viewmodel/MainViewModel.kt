package com.bit2b.gear.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ProviderUseCase {
    fun execute(): MyState {
        return MyState.Success
    }
}

class MainViewModel: ViewModel(){

    private val _state: MutableLiveData<MyState> = MutableLiveData()
    val state: LiveData<MyState> = _state

    fun interactor(interactor: String) {
        when (interactor) {
            "AnyInteractor" -> {
                executarMetodo()
            }
        }
    }

    private fun executarMetodo() {
        viewModelScope.launch {
            try {
                _state.value = MyState.Loading
                delay(1000)
                _state.value = MyState.Success
                delay(1000)
                when (ProviderUseCase().execute()) {
                    MyState.Success -> {
                        _state.value = MyState.Success
                    }
                    else -> {
                        _state.value = MyState.Failure
                    }
                }
            } catch (e: Exception) {
                _state.value = MyState.Failure
            }
        }
    }
}

