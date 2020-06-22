package com.namget.myarchitecture.data.source.local

import android.content.Context
import com.namget.myarchitecture.data.response.RepoInfoResponse
import com.namget.myarchitecture.data.response.RepoListResponse
import com.namget.myarchitecture.data.response.UserInfoResponse
import com.namget.myarchitecture.data.source.RepoDataSource
import com.namget.myarchitecture.data.source.local.dao.RepoDao
import com.namget.myarchitecture.data.source.local.entity.RepoItemEntity
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Namget on 2019.10.24.
 */
class RepoLocalDataSourceImpl @Inject constructor(private val repoDao : RepoDao) : RepoDataSource {

    override fun getRepositoryList(searchName: String): Single<RepoListResponse> {
        throw UnsupportedOperationException()
    }
    override fun getUserInfo(id: String): Single<UserInfoResponse> {
        throw UnsupportedOperationException()
    }
    override fun getRepoInfo(repoUrl: String): Single<RepoInfoResponse> {
        throw UnsupportedOperationException()
    }

    override fun insertRepoData(repoItem: RepoItemEntity): Completable =
        repoDao.insert(repoItem)

    override fun selectRepoData(): Observable<List<RepoItemEntity>> =
        repoDao.selectRepoList()

}