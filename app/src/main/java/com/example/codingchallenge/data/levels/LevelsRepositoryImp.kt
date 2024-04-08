package com.example.codingchallenge.data.levels

import com.example.codingchallenge.data.domain.model.levels.LevelDatabaseModel
import com.example.codingchallenge.data.domain.model.levels.LevelsResponse
import javax.inject.Inject

class LevelsRepositoryImp @Inject constructor(
    private val localRepo: LevelLocalRepository,
    private val remoteRepository: LevelsRemoteRepository
) : LevelsRepository {
    override suspend fun getLevels() = remoteRepository.getLevels()

    override suspend fun getLevelsFromAsset(): LevelsResponse? {
        return try {
            localRepo.getLevelsFromAsset()
        } catch (exception: Exception) {
            null
        }
    }

    override suspend fun saveLevels(levelDatabaseList: List<LevelDatabaseModel>) {
        TODO("Not yet implemented")
    }
}