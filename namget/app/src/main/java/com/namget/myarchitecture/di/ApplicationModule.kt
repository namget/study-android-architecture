package com.namget.myarchitecture.di

import android.app.Application
import android.content.Context
import com.namget.myarchitecture.ui.MyApplication
import dagger.Binds
import dagger.Module

@Module
abstract class ApplicationModule {
    @Binds
    abstract fun bindContext(application: Application) : Context
}