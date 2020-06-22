package com.namget.myarchitecture.ui.main.di

import com.namget.myarchitecture.data.repository.RepoRepository
import com.namget.myarchitecture.ui.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
class MainModule {
    @Provides
    fun bindViewModel(repoRepository: RepoRepository): MainViewModel{
        return MainViewModel(repoRepository)
    }
}