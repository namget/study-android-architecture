package com.namget.myarchitecture.domain

import com.namget.myarchitecture.data.repository.RepoRepository
import com.namget.myarchitecture.data.response.RepoInfoResponse
import com.namget.myarchitecture.data.source.MyResult

/**
 * Created by Namget on 2020.01.06.
 */
class ReqRepoDataUseCase(private val repoRepository: RepoRepository) {

    suspend operator fun invoke(repoUrl: String): MyResult<RepoInfoResponse> =
        repoRepository.getRepoInfo(repoUrl)
}