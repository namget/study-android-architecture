package com.namget.myarchitecture.data.source.remote

import com.namget.myarchitecture.data.response.RepoInfoResponse
import com.namget.myarchitecture.data.response.RepoListResponse
import com.namget.myarchitecture.data.response.UserInfoResponse
import com.namget.myarchitecture.data.source.RepoDataSource
import com.namget.myarchitecture.data.source.Result
import com.namget.myarchitecture.data.source.local.entity.RepoItemEntity
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

/**
 * Created by Namget on 2019.10.24.
 */
class RepoRemoteDataSource(
    private val apiService: ApiService,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : RepoDataSource {


    override suspend fun insertRepoData(repoItem: RepoItemEntity) {
        throw UnsupportedOperationException()
    }

    override suspend fun selectRepoData(): Result<List<RepoItemEntity>> {
        throw UnsupportedOperationException()
    }

    override suspend fun getRepositoryList(searchName: String): Result<RepoListResponse> =
        withContext(ioDispatcher) {
            return@withContext try {
                Result.Success(apiService.getRepositoryList(searchName))
            } catch (e: Exception) {
                Result.Error(e)
            }
        }

    override suspend fun getUserInfo(id: String): Result<UserInfoResponse> =
        withContext(ioDispatcher) {
            return@withContext try {
                Result.Success(apiService.getUserInfo(id))
            } catch (e: Exception) {
                Result.Error(e)
            }
        }


    override suspend fun getRepoInfo(repoUrl: String): Result<RepoInfoResponse> =
        withContext(ioDispatcher) {
            return@withContext try {
                Result.Success(apiService.getRepoInfo(repoUrl))
            } catch (e: Exception) {
                Result.Error(e)
            }
        }
}