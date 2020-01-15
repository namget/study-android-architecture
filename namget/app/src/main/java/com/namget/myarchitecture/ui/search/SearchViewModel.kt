package com.namget.myarchitecture.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.namget.myarchitecture.data.response.RepoListResponse
import com.namget.myarchitecture.data.source.MyResult
import com.namget.myarchitecture.domain.InsertRepoDataUseCase
import com.namget.myarchitecture.domain.ReqRepoListUseCase
import com.namget.myarchitecture.ext.e
import com.namget.myarchitecture.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Namget on 2019.12.01.
 */
class SearchViewModel(
    private val reqRepoListUseCase: ReqRepoListUseCase,
    private val insertRepoDataUseCase: InsertRepoDataUseCase
) : BaseViewModel() {
    private val _repoList = MutableLiveData<List<RepoListResponse.RepoItem?>>()
    val repoList: LiveData<List<RepoListResponse.RepoItem?>> get() = _repoList

    fun requestRepoList(query: String) {
        showLoading()
        viewModelScope.launch {
            val repo = reqRepoListUseCase(query)
            _repoList.value = if (repo is MyResult.Success) repo.data else null
            hideLoading()
        }
    }


    fun insertRepoData(repoItem: RepoListResponse.RepoItem) {
        viewModelScope.launch(Dispatchers.IO) {
            insertRepoDataUseCase(repoItem.toRepoEntity())
            e(TAG, "inserted")
        }
    }


    companion object {
        private const val TAG = "SearchViewModel"
    }
}