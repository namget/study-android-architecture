package com.namget.myarchitecture.ui

import android.app.Application
import com.namget.myarchitecture.data.repository.RepoRepositoryImpl_Factory.create
import com.namget.myarchitecture.data.source.local.RepoLocalDataSourceImpl
import com.namget.myarchitecture.di.AppComponent
import com.namget.myarchitecture.di.AppModule_ProivdeRetrofitFactory.create
import com.namget.myarchitecture.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.HasAndroidInjector
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by Namget on 2019.10.25.
 */
@HiltAndroidApp
class MyApplication : Application(){
    val appComponent : AppComponent by lazy {
        initializeComponent()
    }

    open fun initializeComponent(): AppComponent {
        return DaggerAppComponent.factory().create(applicationContext)

    }

    override fun onCreate() {
        super.onCreate()
    }
}
