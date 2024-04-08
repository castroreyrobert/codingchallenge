package com.example.codingchallenge.data.levels

import com.example.codingchallenge.data.domain.model.levels.Level.Companion.toDb
import com.example.codingchallenge.data.domain.model.levels.LevelActivity
import com.example.codingchallenge.data.domain.model.levels.LevelActivityDatabaseModel
import com.example.codingchallenge.data.domain.model.levels.LevelDatabaseModel
import com.example.codingchallenge.data.domain.model.levels.LevelsResponse
import com.example.codingchallenge.ui.home.LevelUIModel
import com.example.codingchallenge.ui.home.LevelUIModel.Companion.toUIModel
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

    override suspend fun getLevelList(): List<LevelUIModel> {
        return try {
            val levelUIModelList = mutableListOf<LevelUIModel>()
            withContext(Dispatchers.IO) {
                if (!isCache) {
                    val activityList = mutableListOf<LevelActivityDatabaseModel>()
                    val levelsResponse = localRepo.getLevelsFromAsset()
                    val databaseModel = levelsResponse?.levels?.map { it.toDb() }
                    levelsResponse?.levels?.forEach { level ->
                        level.activities.forEach {
                            activityList.add(
                                LevelActivityDatabaseModel(
                                    name = it.title,
                                    description = it.description,
                                    level = level.level,
                                    icon = it.icon.file.url,
                                    id = it.id
                                )
                            )
                        }

                    }

                    if (activityList.isNotEmpty()) {
                        localRepo.saveActivities(activityList)
                    }

                    if (databaseModel != null) {
                        localRepo.saveLevels(databaseModel)
                        isCache = true
                    }

                    levelUIModelList.addAll(levelsResponse?.levels?.map { it.toUIModel() } ?: emptyList())

                } else {
                    localRepo.getLevelsFromDb().forEach {
                        val localRepo = localRepo.getLevelActivitiesFromDb(it.level)
                        levelUIModelList.add(it.toUIModel(localRepo))
                    }
                }
               levelUIModelList
            }
        } catch (exception: Exception) {
            emptyList()
        }
    }

    override fun saveLevels(levelDatabaseList: List<LevelDatabaseModel>) {
        TODO("Not yet implemented")
    }

    override fun saveActivities(levelActivity: List<LevelActivityDatabaseModel>) {
        TODO("Not yet implemented")
    }
}