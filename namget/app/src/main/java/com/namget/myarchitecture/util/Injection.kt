package com.namget.myarchitecture.util

import android.content.Context
import com.namget.myarchitecture.data.repository.RepoRepository
import com.namget.myarchitecture.data.repository.RepoRepositoryImpl
import com.namget.myarchitecture.data.source.RepoDataSource
import com.namget.myarchitecture.data.source.local.AppDatabase
import com.namget.myarchitecture.data.source.local.RepoLocalDataSource
import com.namget.myarchitecture.data.source.remote.ApiService
import com.namget.myarchitecture.data.source.remote.RepoRemoteDataSource
import com.namget.myarchitecture.data.source.remote.RetrofitBuilder

/**
 * Created by Namget on 2020.01.04.
 */
object Injection {

    fun provideRepoRepository(context: Context): RepoRepository {
        val appDatabase = AppDatabase.getInstance(context)
        val apiService: ApiService = RetrofitBuilder.repoApi
        return RepoRepositoryImpl(
            repoRemoteDataSource = RepoRemoteDataSource(apiService),
            repoLocalDataSource = RepoLocalDataSource(appDatabase)
        )
    }
}