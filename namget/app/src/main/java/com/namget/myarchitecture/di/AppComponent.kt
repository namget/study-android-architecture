package com.namget.myarchitecture.di

import android.app.Application
import android.content.Context
import com.namget.myarchitecture.ui.MyApplication
import com.namget.myarchitecture.ui.main.di.MainComponent
import com.namget.myarchitecture.ui.repo.di.RepoComponent
import com.namget.myarchitecture.ui.repo.di.SearchComponent
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.android.AndroidInjector
import dagger.hilt.InstallIn
import javax.inject.Singleton

@Singleton
@Component(modules = [ RepositoryModule::class, SubComponentModule::class, AppModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }
    fun mainComponent(): MainComponent.Factory
    fun repoComponent(): RepoComponent.Factory
    fun searchComponent(): SearchComponent.Factory
}

@Module(subcomponents = [MainComponent::class, RepoComponent::class, SearchComponent::class])
object SubComponentModule
