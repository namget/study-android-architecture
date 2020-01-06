package com.namget.myarchitecture.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.namget.myarchitecture.data.repository.RepoRepository
import com.namget.myarchitecture.domain.*
import com.namget.myarchitecture.ui.main.MainViewModel
import com.namget.myarchitecture.ui.repo.RepoViewModel
import com.namget.myarchitecture.ui.search.SearchViewModel

/**
 * Created by Namget on 2020.01.04.
 */
@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val repoRepository: RepoRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        with(modelClass) {
            when {
                isAssignableFrom(MainViewModel::class.java) ->
                    MainViewModel(SelectRepoDataUseCase(repoRepository))
                isAssignableFrom(RepoViewModel::class.java) ->
                    RepoViewModel(
                        ReqUserDataUseCase(repoRepository),
                        ReqRepoDataUseCase(repoRepository)
                    )
                isAssignableFrom(SearchViewModel::class.java) ->
                    SearchViewModel(
                        ReqRepoListUseCase(repoRepository),
                        InsertRepoDataUseCase(repoRepository)
                    )
                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T

}