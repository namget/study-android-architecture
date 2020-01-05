package com.namget.myarchitecture.data.source.local

import android.content.Context
import com.namget.myarchitecture.data.response.RepoInfoResponse
import com.namget.myarchitecture.data.response.RepoListResponse
import com.namget.myarchitecture.data.response.UserInfoResponse
import com.namget.myarchitecture.data.source.RepoDataSource
import com.namget.myarchitecture.data.source.Result
import com.namget.myarchitecture.data.source.local.dao.RepoDao
import com.namget.myarchitecture.data.source.local.entity.RepoItemEntity
import io.reactivex.Observable
import io.reactivex.Single
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

/**
 * Created by Namget on 2019.10.24.
 */
class RepoLocalDataSource(
    private val repoDao: RepoDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : RepoDataSource {
    override suspend fun getRepositoryList(searchName: String): Result<RepoListResponse> {
        throw UnsupportedOperationException()
    }

    override suspend fun getUserInfo(id: String): Result<UserInfoResponse> {
        throw UnsupportedOperationException()
    }

    override suspend fun getRepoInfo(repoUrl: String): Result<RepoInfoResponse> {
        throw UnsupportedOperationException()
    }

    override suspend fun insertRepoData(repoItem: RepoItemEntity) =
        repoDao.insert(repoItem)

    override suspend fun selectRepoData(): Result<List<RepoItemEntity>> = withContext(ioDispatcher) {
        return@withContext try {
            Result.Success(repoDao.selectRepoList())
        } catch (e: Exception) {
            Result.Error(e)
        }
    }


}