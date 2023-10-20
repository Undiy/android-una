package com.example.una.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.una.R

enum class UnaCategory(
    @StringRes val title: Int,
    @DrawableRes val icon: Int
) {
    All(
        R.string.all,
        R.drawable.outline_place_24
    ),
    MountainsAndRocks(
        R.string.mountains_rocks,
        R.drawable.outline_landscape_24
    ),
    WaterSites(
        R.string.water_sites,
        R.drawable.outline_kayaking_24
    ),
    Caves(
        R.string.caves,
        R.drawable.axe_icon
    )
}