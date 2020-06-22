package com.namget.myarchitecture.ui.repo.di

import com.namget.myarchitecture.ui.main.MainActivity
import com.namget.myarchitecture.ui.search.SearchActivity
import dagger.Subcomponent


@Subcomponent(modules = [SearchModule::class])
interface SearchComponent{
    @Subcomponent.Factory
    interface Factory{
        fun create() : SearchComponent
    }

    fun inject(activity : SearchActivity)
}
