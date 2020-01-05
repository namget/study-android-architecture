package com.namget.myarchitecture.ui

import android.app.Application
import com.namget.myarchitecture.data.repository.RepoRepository
import com.namget.myarchitecture.data.source.local.RepoLocalDataSource
import com.namget.myarchitecture.util.ServiceLocator

/**
 * Created by Namget on 2019.10.25.
 */
class MyApplication : Application() {
    val repoRepository: RepoRepository get() = ServiceLocator.provideRepoRepository(this)

    override fun onCreate() {
        super.onCreate()
    }

}