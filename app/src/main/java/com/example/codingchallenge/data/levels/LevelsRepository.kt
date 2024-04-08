package com.example.codingchallenge.data.levels

import com.example.codingchallenge.domain.model.LevelsResponse
import com.example.codingchallenge.domain.model.NetworkData
import com.haroldadmin.cnradapter.NetworkResponse

interface LevelsRepository {
    suspend fun getLevels():NetworkResponse<NetworkData.NetworkResponseSuccessDataModel<LevelsResponse>, NetworkData.NetworkResponseErrorDataModel<Nothing>>

    suspend fun getLevelsFromAsset(): LevelsResponse?

}