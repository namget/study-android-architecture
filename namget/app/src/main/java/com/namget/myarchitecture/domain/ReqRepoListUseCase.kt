package com.namget.myarchitecture.domain

import com.namget.myarchitecture.data.repository.RepoRepository
import com.namget.myarchitecture.data.response.RepoListResponse
import com.namget.myarchitecture.data.source.MyResult

/**
 * Created by Namget on 2020.01.05.
 */
class ReqRepoListUseCase(private val repoRepository: RepoRepository) {

    suspend operator fun invoke(searchName: String): MyResult<List<RepoListResponse.RepoItem?>> {
        val result = repoRepository.getRepositoryList(searchName)
        return if (result is MyResult.Success) {
            MyResult.Success(result.data.items ?: arrayListOf())
        } else {
            val error = if (result is MyResult.Error) {
                result.exception
            } else {
                Exception("")
            }
            MyResult.Error(error)
        }
    }
}