package com.namget.myarchitecture.data.source.remote

import com.namget.myarchitecture.data.response.RepoInfoResponse
import com.namget.myarchitecture.data.response.RepoListResponse
import com.namget.myarchitecture.data.response.UserInfoResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Namget on 2019.10.22.
 */
interface ApiService {

    @GET("search/repositories")
    suspend fun getRepositoryList(@Query("q") searchName: String): RepoListResponse

    @GET("users/{id}")
    suspend fun getUserInfo(@Path("id") userUrl: String): UserInfoResponse

    @GET("repos/{repoUrl}")
    suspend fun getRepoInfo(@Path("repoUrl", encoded = true) repoUrl: String): RepoInfoResponse
}