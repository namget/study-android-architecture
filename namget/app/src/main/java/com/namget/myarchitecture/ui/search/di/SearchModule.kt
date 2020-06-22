package com.namget.myarchitecture.ui.repo.di

import com.namget.myarchitecture.data.repository.RepoRepository
import com.namget.myarchitecture.ui.search.SearchViewModel
import dagger.Module
import dagger.Provides

@Module
class SearchModule {
    @Provides
    fun bindViewModel(repoRepository: RepoRepository): SearchViewModel {
        return SearchViewModel(repoRepository)
    }
}