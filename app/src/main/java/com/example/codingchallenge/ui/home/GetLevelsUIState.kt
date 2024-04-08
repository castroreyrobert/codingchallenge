package com.example.codingchallenge.ui.home

import com.example.codingchallenge.data.domain.model.levels.Level

sealed interface GetLevelsUIState {

    data class Success(val levels: List<Level>): GetLevelsUIState

    data class LoadFailed(val message: String): GetLevelsUIState

    data object ShowProgress: GetLevelsUIState
}