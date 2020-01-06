package com.namget.myarchitecture.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Namget on 2019.12.01.
 */
abstract class BaseViewModel : ViewModel() {
    protected val _isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val isLoading: LiveData<Boolean> get() = _isLoading


    override fun onCleared() {
        super.onCleared()
    }
}