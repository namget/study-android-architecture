package com.namget.myarchitecture.data.repository

import com.namget.myarchitecture.data.response.RepoInfoResponse
import com.namget.myarchitecture.data.response.RepoListResponse
import com.namget.myarchitecture.data.response.UserInfoResponse
import com.namget.myarchitecture.data.source.RepoDataSource
import com.namget.myarchitecture.data.source.Result
import com.namget.myarchitecture.data.source.local.entity.RepoItemEntity
import com.namget.myarchitecture.ext.withScheduler
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.functions.BiFunction

/**
 * Created by Namget on 2019.10.25.
 */
class RepoRepositoryImpl(
    private val repoRemoteDataSource: RepoDataSource,
    private val repoLocalDataSource: RepoDataSource
) : RepoRepository {

    override suspend fun getRepositoryList(searchName: String): Result<RepoListResponse> =
        repoRemoteDataSource.getRepositoryList(searchName)

    override suspend fun getProfileInfo(
        userUrl: String,
        repoUrl: String
    ): Result<Pair<UserInfoResponse, RepoInfoResponse>> {
        repoRemoteDataSource.getUserInfo(userUrl)
        repoRemoteDataSource.getRepoInfo(repoUrl)
        Pair(user, repo)


    }

    override suspend fun insertRepoData(repoItem: RepoItemEntity) =
        repoLocalDataSource.insertRepoData(repoItem)

    override suspend fun selectRepoData(): Result<List<RepoItemEntity>> =
        repoLocalDataSource.selectRepoData()
}