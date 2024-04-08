package com.example.codingchallenge.data.levels

import com.example.codingchallenge.data.api.LevelsApi
import com.example.codingchallenge.data.domain.model.NetworkData
import com.example.codingchallenge.data.domain.model.levels.LevelDatabaseModel
import com.example.codingchallenge.data.domain.model.levels.LevelsResponse
import com.haroldadmin.cnradapter.NetworkResponse

class LevelsRemoteRepository(api: LevelsApi) : LevelsRepository {
    override suspend fun getLevels(): NetworkResponse<NetworkData.NetworkResponseSuccessDataModel<LevelsResponse>, NetworkData.NetworkResponseErrorDataModel<Nothing>> {
        TODO("Not yet implemented")
    }

    override suspend fun getLevelsFromAsset(): LevelsResponse? {
        TODO("Not yet implemented")
    }

    override suspend fun saveLevels(levelDatabaseList: List<LevelDatabaseModel>) {
        TODO("Not yet implemented")
    }

}