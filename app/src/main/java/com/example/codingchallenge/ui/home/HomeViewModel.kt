package com.example.codingchallenge.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codingchallenge.data.levels.LevelsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(val repository: LevelsRepository): ViewModel() {


    private val _levelsUIState = MutableLiveData<GetLevelsUIState>()
    val levelsUIState: LiveData<GetLevelsUIState> = _levelsUIState
    fun getLevels() {
        _levelsUIState.value = GetLevelsUIState.ShowProgress
        viewModelScope.launch {
            try {
                val response = repository.getLevelList()
                if (response.isNotEmpty()) {
                    _levelsUIState.value = GetLevelsUIState.Success(response)
                } else{
                    _levelsUIState.value = GetLevelsUIState.LoadFailed("Something went wrong!")
                }
            } catch (exception: Exception) {
                _levelsUIState.value = GetLevelsUIState.LoadFailed(exception.message.orEmpty())
            }
        }
    }
}