package com.namget.myarchitecture.ui.repo.di

import com.namget.myarchitecture.data.repository.RepoRepository
import com.namget.myarchitecture.ui.main.MainViewModel
import com.namget.myarchitecture.ui.repo.RepoViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
class RepoModule {
    @Provides
    fun bindViewModel(repoRepository: RepoRepository): RepoViewModel{
        return RepoViewModel(repoRepository)
    }
}