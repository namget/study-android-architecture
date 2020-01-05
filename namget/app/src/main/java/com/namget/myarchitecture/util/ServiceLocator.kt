package com.namget.myarchitecture.util

import android.content.Context
import androidx.room.Room
import com.namget.myarchitecture.data.repository.RepoRepository
import com.namget.myarchitecture.data.repository.RepoRepositoryImpl
import com.namget.myarchitecture.data.source.local.AppDatabase
import com.namget.myarchitecture.data.source.local.RepoLocalDataSource
import com.namget.myarchitecture.data.source.remote.ApiService
import com.namget.myarchitecture.data.source.remote.RepoRemoteDataSource
import com.namget.myarchitecture.data.source.remote.RetrofitBuilder
import com.namget.myarchitecture.ext.d

/**
 * Created by Namget on 2020.01.04.
 */
object ServiceLocator {

    @Volatile
    var repoRepository: RepoRepository? = null
    private var database: AppDatabase? = null
    private var apiService: ApiService? = null


    fun provideRepoRepository(context: Context): RepoRepository {
        synchronized(this) {
            return repoRepository ?: createRepoRepository(context)
        }
    }

    private fun createRepoRepository(context: Context): RepoRepository {
        return RepoRepositoryImpl(
            repoRemoteDataSource = createRepoRemoteDataSource(context),
            repoLocalDataSource = createRepoLocalDataSource(context)
        )
    }

    private fun createRepoLocalDataSource(context: Context): RepoLocalDataSource {
        val database = database ?: createDatabase(context)
        return RepoLocalDataSource(database.repoDao())
    }

    private fun createRepoRemoteDataSource(context: Context): RepoRemoteDataSource {
        val apiService = apiService ?: createApiService()
        return RepoRemoteDataSource(apiService)
    }

    private fun createApiService(): ApiService {
        return RetrofitBuilder.createApiService()
    }

    private fun createDatabase(context: Context): AppDatabase {
        synchronized(AppDatabase::class) {
            database = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "repo.db"
            ).build()
        }
        return database!!
    }


}