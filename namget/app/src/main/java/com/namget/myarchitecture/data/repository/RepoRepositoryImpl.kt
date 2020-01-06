package com.namget.myarchitecture.data.repository

import androidx.lifecycle.LiveData
import com.namget.myarchitecture.data.response.RepoInfoResponse
import com.namget.myarchitecture.data.response.RepoListResponse
import com.namget.myarchitecture.data.response.UserInfoResponse
import com.namget.myarchitecture.data.source.MyResult
import com.namget.myarchitecture.data.source.RepoDataSource
import com.namget.myarchitecture.data.source.local.entity.RepoItemEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * Created by Namget on 2019.10.25.
 */
class RepoRepositoryImpl(
    private val repoRemoteDataSource: RepoDataSource,
    private val repoLocalDataSource: RepoDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : RepoRepository {

    override suspend fun getRepositoryList(searchName: String): MyResult<RepoListResponse> =
        repoRemoteDataSource.getRepositoryList(searchName)

    override suspend fun getUserInfo(
        userUrl: String
    ): MyResult<UserInfoResponse> =
        repoRemoteDataSource.getUserInfo(userUrl)


    override suspend fun getRepoInfo(
        repoUrl: String
    ): MyResult<RepoInfoResponse> =
        repoRemoteDataSource.getRepoInfo(repoUrl)


    override suspend fun insertRepoData(repoItem: RepoItemEntity) =
        repoLocalDataSource.insertRepoData(repoItem)

    override suspend fun selectRepoData(): LiveData<MyResult<List<RepoItemEntity>>> =
        repoLocalDataSource.selectRepoData()
}