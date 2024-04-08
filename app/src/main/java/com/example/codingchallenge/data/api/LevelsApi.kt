package com.example.codingchallenge.data.api

import com.example.codingchallenge.data.domain.model.levels.LevelsResponse
import com.example.codingchallenge.data.domain.model.NetworkData
import com.haroldadmin.cnradapter.NetworkResponse
import retrofit2.http.GET

interface LevelsApi {

   @GET ("sample/endpoint")
    suspend fun getLevels() : NetworkResponse<NetworkData.NetworkResponseSuccessDataModel<LevelsResponse>, NetworkData.NetworkResponseErrorDataModel<Nothing>>
}