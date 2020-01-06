package com.namget.myarchitecture.domain

import com.namget.myarchitecture.data.repository.RepoRepository
import com.namget.myarchitecture.data.response.UserInfoResponse
import com.namget.myarchitecture.data.source.MyResult

/**
 * Created by Namget on 2020.01.05.
 */
class ReqUserDataUseCase(private val repoRepository: RepoRepository) {

    suspend operator fun invoke(url: String): MyResult<UserInfoResponse> =
        repoRepository.getUserInfo(url)

}