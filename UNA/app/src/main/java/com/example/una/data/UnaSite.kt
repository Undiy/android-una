package com.example.una.data

import android.net.Uri
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class UnaSite(
    @StringRes val title: Int,
    @StringRes val info: Int,
    @DrawableRes val image: Int,
    val geoUri: Uri,
    val category: UnaCategory
)
