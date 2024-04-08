package com.example.codingchallenge.di

import android.content.Context
import com.example.codingchallenge.data.api.LevelsApi
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
    fun provideLevelsRepository(@ApplicationContext context: Context, api: LevelsApi): LevelsRepository =
        LevelsRepositoryImp(context, api)
}