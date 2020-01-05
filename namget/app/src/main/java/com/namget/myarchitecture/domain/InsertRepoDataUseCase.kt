package com.namget.myarchitecture.domain

import com.namget.myarchitecture.data.repository.RepoRepository

/**
 * Created by Namget on 2020.01.05.
 */
class InsertRepoDataUseCase(private val repoRepository: RepoRepository) {

    suspend operator fun invoke() {

    }
}