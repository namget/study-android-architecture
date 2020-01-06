package com.namget.myarchitecture.data.source.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.namget.myarchitecture.data.response.RepoInfoResponse
import com.namget.myarchitecture.data.response.RepoListResponse
import com.namget.myarchitecture.data.response.UserInfoResponse
import com.namget.myarchitecture.data.source.MyResult
import com.namget.myarchitecture.data.source.RepoDataSource
import com.namget.myarchitecture.data.source.local.dao.RepoDao
import com.namget.myarchitecture.data.source.local.entity.RepoItemEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * Created by Namget on 2019.10.24.
 */
class RepoLocalDataSource(
    private val repoDao: RepoDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : RepoDataSource {
    override suspend fun getRepositoryList(searchName: String): MyResult<RepoListResponse> {
        throw UnsupportedOperationException()
    }

    override suspend fun getUserInfo(id: String): MyResult<UserInfoResponse> {
        throw UnsupportedOperationException()
    }

    override suspend fun getRepoInfo(repoUrl: String): MyResult<RepoInfoResponse> {
        throw UnsupportedOperationException()
    }

    override suspend fun insertRepoData(repoItem: RepoItemEntity) =
        repoDao.insert(repoItem)

    override suspend fun selectRepoData(): LiveData<MyResult<List<RepoItemEntity>>> =
        repoDao.selectRepoList().map {
            MyResult.Success(it)
        }
}