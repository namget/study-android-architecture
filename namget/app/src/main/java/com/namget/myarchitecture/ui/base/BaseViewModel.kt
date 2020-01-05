package com.namget.myarchitecture.ui.base

import androidx.databinding.BaseObservable
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Namget on 2019.12.01.
 */
abstract class BaseViewModel : ViewModel() {

    override fun onCleared() {
        super.onCleared()
    }
}