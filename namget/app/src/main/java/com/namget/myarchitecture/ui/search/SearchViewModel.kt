package com.namget.myarchitecture.ui.search

import androidx.databinding.ObservableArrayList
import com.namget.myarchitecture.data.response.RepoListResponse
import com.namget.myarchitecture.domain.InsertRepoDataUseCase
import com.namget.myarchitecture.domain.ReqRepoListUseCase
import com.namget.myarchitecture.ext.e
import com.namget.myarchitecture.ext.plusAssign
import com.namget.myarchitecture.ui.base.BaseViewModel

/**
 * Created by Namget on 2019.12.01.
 */
class SearchViewModel(
    private val reqRepoListUseCase: ReqRepoListUseCase,
    private val insertRepoDataUseCase: InsertRepoDataUseCase
) : BaseViewModel() {
    val repoList = ObservableArrayList<RepoListResponse.RepoItem?>()

    fun requestRepoList(query: String) {
//        keyboardCallback(false)
        isLoading.set(true)
        disposable += repoRepository.getRepositoryList(query)
            .subscribe({
                repoList.clear()
                repoList.addAll(it.items ?: listOf())
                isLoading.set(false)
            }, {
                //                toastItemCallback(R.string.error)
                isLoading.set(false)
            })
    }


    fun insertRepoData(repoItem: RepoListResponse.RepoItem) {
        InsertRepoDataUseCase(repoItem.toRepoEntity())
        e(TAG, "inserted")
    }


    companion object {
        private const val TAG = "SearchViewModel"
    }
}