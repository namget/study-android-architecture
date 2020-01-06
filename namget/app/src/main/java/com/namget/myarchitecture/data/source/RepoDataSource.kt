package com.namget.myarchitecture.data.source

import androidx.lifecycle.LiveData
import com.namget.myarchitecture.data.response.RepoInfoResponse
import com.namget.myarchitecture.data.response.RepoListResponse
import com.namget.myarchitecture.data.response.UserInfoResponse
import com.namget.myarchitecture.data.source.local.entity.RepoItemEntity

interface RepoDataSource {
    suspend fun insertRepoData(repoItem : RepoItemEntity)
    suspend fun selectRepoData() : LiveData<MyResult<List<RepoItemEntity>>>
    suspend fun getRepositoryList(searchName: String): MyResult<RepoListResponse>
    suspend fun getUserInfo(id: String): MyResult<UserInfoResponse>
    suspend fun getRepoInfo(repoUrl: String): MyResult<RepoInfoResponse>
}