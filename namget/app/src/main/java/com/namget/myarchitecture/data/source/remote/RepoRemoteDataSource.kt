package com.namget.myarchitecture.data.source.remote

import androidx.lifecycle.LiveData
import com.namget.myarchitecture.data.response.RepoInfoResponse
import com.namget.myarchitecture.data.response.RepoListResponse
import com.namget.myarchitecture.data.response.UserInfoResponse
import com.namget.myarchitecture.data.source.MyResult
import com.namget.myarchitecture.data.source.RepoDataSource
import com.namget.myarchitecture.data.source.local.entity.RepoItemEntity
import com.namget.myarchitecture.ext.e
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
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

    override suspend fun selectRepoData(): LiveData<MyResult<List<RepoItemEntity>>> {
        throw UnsupportedOperationException()
    }

    override suspend fun getRepositoryList(searchName: String): MyResult<RepoListResponse> =
        withContext(ioDispatcher) {
            return@withContext try {
                MyResult.Success(apiService.getRepositoryList(searchName))
            } catch (e: Exception) {
                e("getRepositoryList", "error", e)
                MyResult.Error(e)
            }
        }

    override suspend fun getUserInfo(id: String): MyResult<UserInfoResponse> =
        withContext(ioDispatcher) {
            return@withContext try {
                MyResult.Success(apiService.getUserInfo(id))
            } catch (e: Exception) {
                MyResult.Error(e)
            }
        }


    override suspend fun getRepoInfo(repoUrl: String): MyResult<RepoInfoResponse> =
        withContext(ioDispatcher) {
            return@withContext try {
                MyResult.Success(apiService.getRepoInfo(repoUrl))
            } catch (e: Exception) {
                MyResult.Error(e)
            }
        }
}