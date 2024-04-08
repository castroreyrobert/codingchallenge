package com.example.codingchallenge.data.levels

import com.example.codingchallenge.data.domain.model.levels.LevelsResponse
import com.example.codingchallenge.data.domain.model.NetworkData
import com.example.codingchallenge.data.domain.model.levels.Level
import com.example.codingchallenge.data.domain.model.levels.LevelDatabaseModel
import com.haroldadmin.cnradapter.NetworkResponse

interface LevelsRepository {
    suspend fun getLevels():NetworkResponse<NetworkData.NetworkResponseSuccessDataModel<LevelsResponse>, NetworkData.NetworkResponseErrorDataModel<Nothing>>

    suspend fun getLevelsFromAsset(): LevelsResponse?

    suspend fun saveLevels(levelDatabaseList: List<LevelDatabaseModel>)

}