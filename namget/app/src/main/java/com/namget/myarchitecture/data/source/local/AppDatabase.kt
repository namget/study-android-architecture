package com.namget.myarchitecture.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.namget.myarchitecture.data.source.local.dao.RepoDao
import com.namget.myarchitecture.data.source.local.entity.RepoItemEntity

/**
 * Created by Namget on 2019.10.25.
 */
@Database(entities = [RepoItemEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun repoDao(): RepoDao

    //싱글톤 객체를 서비스로케이터로 옮김
}