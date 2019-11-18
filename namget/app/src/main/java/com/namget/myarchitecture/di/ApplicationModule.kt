package com.namget.myarchitecture.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

/**
 * Created by Namget on 2019.11.18.
 */
@Module
abstract class ApplicationModule {

    @Binds
    abstract fun bindContext(application: Application): Context
}