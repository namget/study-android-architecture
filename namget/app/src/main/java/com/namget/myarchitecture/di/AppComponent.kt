package com.namget.myarchitecture.di

import android.app.Application
import com.namget.myarchitecture.RepoApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * Created by Namget on 2019.11.18.
 */
@Singleton
@Component(modules = {ApplicationModule::class})
interface AppComponent : AndroidInjector<RepoApplication> {

    //테스트시 아래와 같이 가져와서 테스트 가능
//    fun getTasksRepository(): TasksRepository?


    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): AppComponent.Builder
        fun build(): AppComponent
    }

}