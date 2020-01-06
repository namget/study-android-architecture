package com.namget.myarchitecture.domain

import com.namget.myarchitecture.data.repository.RepoRepository
import com.namget.myarchitecture.data.source.local.entity.RepoItemEntity

/**
 * Created by Namget on 2020.01.05.
 */
class InsertRepoDataUseCase(private val repoRepository: RepoRepository) {

    suspend operator fun invoke(repoItemEntity: RepoItemEntity) {
        repoRepository.insertRepoData(repoItemEntity)
    }
}