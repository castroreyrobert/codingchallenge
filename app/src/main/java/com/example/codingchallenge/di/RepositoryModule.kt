package com.example.codingchallenge.di

import android.content.Context
import com.example.codingchallenge.data.api.LevelsApi
import com.example.codingchallenge.data.domain.model.levels.LevelActivityDatabaseModel
import com.example.codingchallenge.data.levels.LevelActivityDatabase
import com.example.codingchallenge.data.levels.LevelDatabase
import com.example.codingchallenge.data.levels.LevelLocalRepository
import com.example.codingchallenge.data.levels.LevelsRemoteRepository
import com.example.codingchallenge.data.levels.LevelsRepository
import com.example.codingchallenge.data.levels.LevelsRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideLevelsRepository(localRepository: LevelLocalRepository, remoteRepository: LevelsRemoteRepository): LevelsRepository =
        LevelsRepositoryImp(localRepository, remoteRepository)


    @Singleton
    @Provides
    fun provideLevelLocalRepository(@ApplicationContext context: Context, database: LevelDatabase, databaseActivity: LevelActivityDatabase) = LevelLocalRepository(
        database, databaseActivity, context
    )

    @Singleton
    @Provides
    fun provideLevelRemoteRepository(api: LevelsApi) = LevelsRemoteRepository(
        api = api
    )
}