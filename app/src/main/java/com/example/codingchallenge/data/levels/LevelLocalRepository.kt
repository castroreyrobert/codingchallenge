package com.example.codingchallenge.data.levels

import android.content.Context
import com.example.codingchallenge.data.domain.model.NetworkData
import com.example.codingchallenge.data.domain.model.levels.LevelActivityDatabaseModel
import com.example.codingchallenge.data.domain.model.levels.LevelDatabaseModel
import com.example.codingchallenge.data.domain.model.levels.LevelsResponse
import com.example.codingchallenge.ui.home.LevelUIModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.haroldadmin.cnradapter.NetworkResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONException
import java.io.IOException
import javax.inject.Inject

class LevelLocalRepository @Inject constructor(
    private val databaseLevel: LevelDatabase,
    private val databaseActivityDatabase: LevelActivityDatabase,
    private val context: Context
): LevelsRepository {

    companion object {
        var isCache = false
    }

    override suspend fun getLevels(): NetworkResponse<
            NetworkData.NetworkResponseSuccessDataModel<LevelsResponse>,
            NetworkData.NetworkResponseErrorDataModel<Nothing>>
    {
        TODO("Not yet implemented")
    }

    suspend fun getLevelsFromAsset(): LevelsResponse? {
        return getLevelAssetJson()
    }

    private fun getLevelAssetJson(): LevelsResponse? {
        return try {
            val jsonString = context.assets.open("coding_challenge_response.json")
                .bufferedReader().use { it.readText() }
            val gson = Gson()
            val type = object : TypeToken<LevelsResponse>() {}.type
            gson.fromJson(jsonString, type)
        } catch (e: IOException) {
            e.printStackTrace()
            null
        } catch (e: JSONException) {
            e.printStackTrace()
            null
        }
    }

    override suspend fun getLevelList(): List<LevelUIModel> {
        TODO("Not yet implemented")
    }

    override fun saveLevels(levelDatabaseList: List<LevelDatabaseModel>) {
        databaseLevel.levelsDao.insertLevelList(levelDatabaseList)
    }

    override fun saveActivities(levelActivity: List<LevelActivityDatabaseModel>) {
        databaseActivityDatabase.levelActivityDao.insertActivityList(levelActivity)
    }

    fun getLevelsFromDb() = databaseLevel.levelsDao.getLevels()

    fun getLevelActivitiesFromDb(level: String) = databaseActivityDatabase.levelActivityDao.getLevelActivityList(level)
}