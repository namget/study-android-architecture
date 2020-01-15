package com.namget.myarchitecture.data.source.remote

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.namget.myarchitecture.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Namget on 2019.10.22.
 */

object RetrofitBuilder {

    //10 sec
    private const val TIMEOUT = 10L
    private const val BASE_URL = "https://api.github.com/"

    private fun createHeaderInterceptor(): Interceptor =
        Interceptor {
            val original = it.request()
            val request = original.newBuilder()
                .method(original.method(), original.body())
                .build()
            it.proceed(request)
        }


    private fun createHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }


    private fun createGsonBuilder(): Gson =
        GsonBuilder().setLenient().create()


    private fun createOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(createHeaderInterceptor())
            .addInterceptor(createHttpLoggingInterceptor())
            .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .build()


    private fun createRetrofit(baseUrl : String = BASE_URL): Retrofit =
        Retrofit.Builder()
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .addConverterFactory(GsonConverterFactory.create(createGsonBuilder()))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(createOkHttpClient())
            .baseUrl(baseUrl)
            .build()

    fun createApiService(): ApiService =
        createRetrofit().create(ApiService::class.java)


}