package com.namget.myarchitecture.ui.main.di

import com.namget.myarchitecture.ui.main.MainActivity
import dagger.Subcomponent


@Subcomponent(modules = [MainModule::class])
interface MainComponent{
    @Subcomponent.Factory
    interface Factory{
        fun create() : MainComponent
    }

    fun inject(activity : MainActivity)
}
