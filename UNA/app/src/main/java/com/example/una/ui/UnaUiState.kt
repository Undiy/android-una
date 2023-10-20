package com.example.una.ui

import com.example.una.data.UnaCategory
import com.example.una.data.UnaDatasource
import com.example.una.data.UnaSite

data class UnaUiState(
    val sites: List<UnaSite> = UnaDatasource.sites,
    val selectedSite: UnaSite? = null,
    val selectedCategory: UnaCategory = UnaCategory.All
)