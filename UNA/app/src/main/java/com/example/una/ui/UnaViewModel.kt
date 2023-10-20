package com.example.una.ui

import androidx.lifecycle.ViewModel
import com.example.una.data.UnaCategory
import com.example.una.data.UnaDatasource
import com.example.una.data.UnaSite
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class UnaViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(UnaUiState())
    val uiState: StateFlow<UnaUiState> = _uiState

    fun updateSelectedSite(site: UnaSite) {
        _uiState.update { currentState ->
            currentState.copy(selectedSite = site)
        }
    }

    fun resetSelectedSite() {
        _uiState.update { currentState ->
            currentState.copy(selectedSite = null)
        }
    }
    fun updateSelectedCategory(category: UnaCategory) {
        _uiState.update { currentState ->
            currentState.copy(
                selectedCategory = category,
                sites = when (category) {
                    UnaCategory.All -> UnaDatasource.sites
                    else -> UnaDatasource.sites.filter { it.category == category }
                }
            )
        }
    }
}