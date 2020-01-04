package com.namget.myarchitecture.util

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.namget.myarchitecture.data.repository.RepoRepository
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
                    MainViewModel(repoRepository)
                isAssignableFrom(RepoViewModel::class.java) ->
                    RepoViewModel(repoRepository)
                isAssignableFrom(SearchViewModel::class.java) ->
                    SearchViewModel(repoRepository)
                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T

    companion object {

        @SuppressLint("StaticFieldLeak")
        @Volatile private var INSTANCE: ViewModelFactory? = null

        fun getInstance(application: Application) =
            INSTANCE ?: synchronized(ViewModelFactory::class.java) {
                INSTANCE ?: ViewModelFactory(
                    Injection.provideRepoRepository(application.applicationContext))
                    .also { INSTANCE = it }
            }

    }

}