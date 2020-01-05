package com.namget.myarchitecture.data.source

import com.namget.myarchitecture.data.response.RepoInfoResponse
import com.namget.myarchitecture.data.response.RepoListResponse
import com.namget.myarchitecture.data.response.UserInfoResponse
import com.namget.myarchitecture.data.source.local.entity.RepoItemEntity
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface RepoDataSource {
    suspend fun insertRepoData(repoItem : RepoItemEntity)
    suspend fun selectRepoData() : Result<List<RepoItemEntity>>
    suspend fun getRepositoryList(searchName: String): Result<RepoListResponse>
    suspend fun getUserInfo(id: String): Result<UserInfoResponse>
    suspend fun getRepoInfo(repoUrl: String): Result<RepoInfoResponse>
}