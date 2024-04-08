package com.example.codingchallenge.data.levels

import com.example.codingchallenge.data.api.LevelsApi
import com.example.codingchallenge.data.domain.model.NetworkData
import com.example.codingchallenge.data.domain.model.levels.LevelActivityDatabaseModel
import com.example.codingchallenge.data.domain.model.levels.LevelDatabaseModel
import com.example.codingchallenge.data.domain.model.levels.LevelsResponse
import com.example.codingchallenge.ui.home.LevelUIModel
import com.haroldadmin.cnradapter.NetworkResponse

class LevelsRemoteRepository(val api: LevelsApi) : LevelsRepository {
    override suspend fun getLevels(): NetworkResponse<NetworkData.NetworkResponseSuccessDataModel<LevelsResponse>, NetworkData.NetworkResponseErrorDataModel<Nothing>> {
        return api.getLevels()
    }

    override fun saveLevels(levelDatabaseList: List<LevelDatabaseModel>) {
        TODO("Not yet implemented")
    }

    override fun saveActivities(levelActivity: List<LevelActivityDatabaseModel>) {
        TODO("Not yet implemented")
    }

    override suspend fun getLevelList(): List<LevelUIModel> {
        TODO("Not yet implemented")
    }

}