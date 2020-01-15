package com.namget.myarchitecture.data.source.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.namget.myarchitecture.data.source.local.entity.RepoItemEntity

/**
 * Created by Namget on 2019.10.25.
 */
@Dao
interface RepoDao : BaseDao<RepoItemEntity> {
    @Query("SELECT * from RepoItem")
    fun selectRepoList(): LiveData<List<RepoItemEntity>>

}