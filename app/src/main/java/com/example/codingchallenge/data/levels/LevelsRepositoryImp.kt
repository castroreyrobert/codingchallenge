package com.example.codingchallenge.data.levels

import android.content.Context
import com.example.codingchallenge.data.api.LevelsApi
import com.example.codingchallenge.domain.model.LevelsResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONException
import java.io.IOException

class LevelsRepositoryImp(val context: Context, val api: LevelsApi) : LevelsRepository {
    override suspend fun getLevels() = api.getLevels()

    override suspend fun getLevelsFromAsset(): LevelsResponse? {
        return try {
            getLevelAssetJson()
        } catch (exception: Exception) {
            null
        }
    }

    private fun getLevelAssetJson(): LevelsResponse? {
        return try {
            val jsonString = context.assets.open("coding_challenge_response.json").bufferedReader().use { it.readText() }
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
}