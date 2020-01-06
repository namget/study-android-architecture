package com.namget.myarchitecture.domain

import androidx.lifecycle.LiveData
import com.namget.myarchitecture.data.repository.RepoRepository
import com.namget.myarchitecture.data.source.MyResult
import com.namget.myarchitecture.data.source.local.entity.RepoItemEntity

/**
 * Created by Namget on 2020.01.05.
 */
class SelectRepoDataUseCase(private val repoRepository: RepoRepository) {

    suspend operator fun invoke() : LiveData<MyResult<List<RepoItemEntity>>> = repoRepository.selectRepoData()
}