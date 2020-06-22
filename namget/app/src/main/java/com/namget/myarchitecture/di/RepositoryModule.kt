package com.namget.myarchitecture.di

import com.namget.myarchitecture.data.repository.RepoRepository
import com.namget.myarchitecture.data.repository.RepoRepositoryImpl
import com.namget.myarchitecture.data.source.local.RepoLocalDataSourceImpl
import com.namget.myarchitecture.data.source.remote.RepoRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object RepositoryModule {
    @Singleton
    @Provides
    fun bindRepository(remote: RepoRemoteDataSourceImpl, local : RepoLocalDataSourceImpl) : RepoRepository{
        return RepoRepositoryImpl(remote,local)
    }
}