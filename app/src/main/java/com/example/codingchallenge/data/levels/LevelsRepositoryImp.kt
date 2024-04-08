package com.example.codingchallenge.data.levels

import com.example.codingchallenge.data.domain.model.levels.Level.Companion.toDb
import com.example.codingchallenge.data.domain.model.levels.LevelActivityDatabaseModel
import com.example.codingchallenge.data.domain.model.levels.LevelDatabaseModel
import com.example.codingchallenge.data.domain.model.levels.LevelsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LevelsRepositoryImp @Inject constructor(
    private val localRepo: LevelLocalRepository,
    private val remoteRepository: LevelsRemoteRepository
) : LevelsRepository {

    companion object {
        var isCache = false
    }
    override suspend fun getLevels() = remoteRepository.getLevels()

    override suspend fun getLevelsFromAsset(): LevelsResponse? {
        return try {
            withContext(Dispatchers.IO) {
                if (!isCache) {
                    val levelsResponse = localRepo.getLevelsFromAsset()
                    val databaseModel = levelsResponse?.levels?.map { it.toDb() }
                    if (databaseModel != null) {
                        localRepo.saveLevels(databaseModel)
                        isCache = true
                    }
                }
                localRepo.getLevelsFromAsset()
            }
        } catch (exception: Exception) {
            null
        }
    }

    override fun saveLevels(levelDatabaseList: List<LevelDatabaseModel>) {
        TODO("Not yet implemented")
    }

    override fun saveActivities(levelActivity: List<LevelActivityDatabaseModel>) {
        TODO("Not yet implemented")
    }
}