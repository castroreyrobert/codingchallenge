package com.example.codingchallenge.data.levels

import android.content.Context
import com.example.codingchallenge.data.domain.model.NetworkData
import com.example.codingchallenge.data.domain.model.levels.LevelDatabaseModel
import com.example.codingchallenge.data.domain.model.levels.LevelsResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.haroldadmin.cnradapter.NetworkResponse
import org.json.JSONException
import java.io.IOException
import javax.inject.Inject

class LevelLocalRepository @Inject constructor(
    private val database: LevelDatabase,
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

    override suspend fun getLevelsFromAsset(): LevelsResponse? {
        isCache = true
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

    override suspend fun saveLevels(levelDatabaseList: List<LevelDatabaseModel>) {
        database.levelsDao.insertLevelList(levelDatabaseList)
    }
}