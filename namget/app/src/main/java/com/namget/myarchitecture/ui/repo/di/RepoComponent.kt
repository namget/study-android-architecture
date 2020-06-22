package com.namget.myarchitecture.ui.repo.di

import com.namget.myarchitecture.ui.main.MainActivity
import com.namget.myarchitecture.ui.repo.RepoActivity
import dagger.Subcomponent


@Subcomponent(modules = [RepoModule::class])
interface RepoComponent{
    @Subcomponent.Factory
    interface Factory{
        fun create() : RepoComponent
    }

    fun inject(activity : RepoActivity)
}
