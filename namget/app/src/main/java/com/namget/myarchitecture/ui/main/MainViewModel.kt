package com.namget.myarchitecture.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.namget.myarchitecture.data.source.MyResult
import com.namget.myarchitecture.data.source.local.entity.RepoItemEntity
import com.namget.myarchitecture.domain.SelectRepoDataUseCase
import com.namget.myarchitecture.ui.base.BaseViewModel

/**
 * Created by Namget on 2019.12.01.
 */
class MainViewModel(
    private val selectRepoDataUseCase: SelectRepoDataUseCase
) : BaseViewModel() {
    private val _repoItemList: LiveData<MyResult<List<RepoItemEntity>>> = liveData {
        emit(MyResult.Loading)
        emitSource(selectRepoDataUseCase())
    }
    val repoItemList: LiveData<List<RepoItemEntity>> = _repoItemList.map {
        when (it) {
            is MyResult.Success -> {
                _isLoading.value = false
                it.data
            }
            is MyResult.Error -> {
                _isLoading.value = false
                emptyList()
            }
            is MyResult.Loading -> {
                _isLoading.value = true
                emptyList()
            }
        }
    }

    companion object {
        private const val TAG = "MainViewModel"
    }

}