package com.example.una.ui

import androidx.lifecycle.ViewModel
import com.example.una.data.UnaSite
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class UnaViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(UnaUiState())
    val uiState: StateFlow<UnaUiState> = _uiState

    fun updateSelectedSite(site: UnaSite) {
        _uiState.update { currentState ->
            currentState.copy(currentSelectedSite = site)
        }
    }

    fun resetSelectedSite() {
        _uiState.update { currentState ->
            currentState.copy(currentSelectedSite = null)
        }
    }
}