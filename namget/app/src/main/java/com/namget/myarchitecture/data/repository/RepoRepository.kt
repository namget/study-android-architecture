package com.namget.myarchitecture.data.repository

import com.namget.myarchitecture.data.response.RepoInfoResponse
import com.namget.myarchitecture.data.response.RepoListResponse
import com.namget.myarchitecture.data.response.UserInfoResponse
import com.namget.myarchitecture.data.source.Result
import com.namget.myarchitecture.data.source.local.entity.RepoItemEntity

/**
 * Created by Namget on 2019.10.25.
 */
interface RepoRepository{
    suspend fun getRepositoryList(searchName: String): Result<RepoListResponse>
    suspend fun getProfileInfo(userUrl: String, repoUrl: String): Result<Pair<UserInfoResponse, RepoInfoResponse>>
    suspend fun insertRepoData(repoItem : RepoItemEntity)
    suspend fun selectRepoData() : Result<List<RepoItemEntity>>

}