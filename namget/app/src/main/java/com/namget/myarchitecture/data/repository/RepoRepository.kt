package com.namget.myarchitecture.data.repository

import androidx.lifecycle.LiveData
import com.namget.myarchitecture.data.response.RepoInfoResponse
import com.namget.myarchitecture.data.response.RepoListResponse
import com.namget.myarchitecture.data.response.UserInfoResponse
import com.namget.myarchitecture.data.source.MyResult
import com.namget.myarchitecture.data.source.local.entity.RepoItemEntity

/**
 * Created by Namget on 2019.10.25.
 */
interface RepoRepository {
    suspend fun getRepositoryList(searchName: String): MyResult<RepoListResponse>
    suspend fun getUserInfo(userUrl: String): MyResult<UserInfoResponse>
    suspend fun getRepoInfo(repoUrl: String): MyResult<RepoInfoResponse>
    suspend fun insertRepoData(repoItem: RepoItemEntity)
    suspend fun selectRepoData(): LiveData<MyResult<List<RepoItemEntity>>>

}