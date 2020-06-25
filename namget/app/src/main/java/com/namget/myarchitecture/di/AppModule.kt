package com.namget.myarchitecture.di

import android.content.Context
import androidx.room.Room
import com.namget.myarchitecture.data.source.RepoDataSource
import com.namget.myarchitecture.data.source.local.AppDatabase
import com.namget.myarchitecture.data.source.local.RepoLocalDataSourceImpl
import com.namget.myarchitecture.data.source.local.dao.RepoDao
import com.namget.myarchitecture.data.source.remote.ApiService
import com.namget.myarchitecture.data.source.remote.RepoRemoteDataSourceImpl
import com.namget.myarchitecture.data.source.remote.RetrofitBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(AppComponent::class)
object AppModule {

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class RepoRemoteDataSource

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class RepoLocalDataSource

    @JvmStatic
    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @JvmStatic
    @Singleton
    @Provides
    fun proivdeRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .addConverterFactory(GsonConverterFactory.create(RetrofitBuilder.createGsonBuilder()))
            .client(RetrofitBuilder.createOkHttpClient())
            .baseUrl(RetrofitBuilder.BASE_URL)
            .build()
    }


    @JvmStatic
    @Singleton
    @RepoRemoteDataSource
    @Provides
    fun provideRepoRemoteDataSourceImpl(apiService: ApiService): RepoDataSource {
        return RepoRemoteDataSourceImpl(apiService)
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideRepoDao(database: AppDatabase) : RepoDao{
        return database.repoDao()
    }

    @JvmStatic
    @Singleton
    @RepoLocalDataSource
    @Provides
    fun provideTasksLocalDataSource(
        repoDao: RepoDao
    ): RepoDataSource {
        return RepoLocalDataSourceImpl(repoDao)
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideDataBase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "repo.db"
        ).build()
    }
}
