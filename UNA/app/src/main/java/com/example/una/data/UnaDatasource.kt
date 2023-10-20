package com.example.una.data

import android.net.Uri
import com.example.una.R

object UnaDatasource {
    val sites = listOf(
        UnaSite(
            title = R.string.chertovo_gorodishche_title,
            info = R.string.chertovo_gorodishche_info,
            image = R.drawable.north_side_of_devil_s_settlement,
            geoUri = Uri.parse("geo:56.941667,60.347222"),
            category = UnaCategory.MountainsAndRocks
        ),
        UnaSite(
            title = R.string.iremel_title,
            info = R.string.iremel_info,
            image = R.drawable.mount_iremel,
            geoUri = Uri.parse("geo:54.515,58.84"),
            category = UnaCategory.MountainsAndRocks
        ),
        UnaSite(
            title = R.string.mount_azov_title,
            info = R.string.mount_azov_info,
            image = R.drawable.mount_azov,
            geoUri = Uri.parse("geo:56.475278,60.086389"),
            category = UnaCategory.MountainsAndRocks
        ),

        UnaSite(
            title = R.string.lake_tavatui_title,
            info = R.string.lake_tavatui_info,
            image = R.drawable.lake_tavatui,
            geoUri = Uri.parse("geo:57.133333,60.183056"),
            category = UnaCategory.WaterSites
        ),
        UnaSite(
            title = R.string.lake_itkul_title,
            info = R.string.lake_itkul_info,
            image = R.drawable.lake_itkul,
            geoUri = Uri.parse("geo:56.15,60.5119"),
            category = UnaCategory.WaterSites
        ),
        UnaSite(
            title = R.string.chusovaya_title,
            info = R.string.chusovaya_info,
            image = R.drawable.maksimovsky_rock_chusovaya_river,
            geoUri = Uri.parse("geo:58.1575,56.3874"),
            category = UnaCategory.WaterSites
        ),

        UnaSite(
            title = R.string.kungur_ice_cave_title,
            info = R.string.kungur_ice_cave_info,
            image = R.drawable.kungur_ice_cave,
            geoUri = Uri.parse("geo:57.4409,57.0059"),
            category = UnaCategory.Caves
        ),
        UnaSite(
            title = R.string.orda_cave_title,
            info = R.string.orda_cave_info,
            image = R.drawable.the_entrance_to_the_orda_cave,
            geoUri = Uri.parse("geo:57.182,56.888056"),
            category = UnaCategory.Caves
        ),
        UnaSite(
            title = R.string.kurgazak_cave_title,
            info = R.string.kurgazak_cave_info,
            image = R.drawable.kurgazak_cave,
            geoUri = Uri.parse("geo:55.138611,58.726111"),
            category = UnaCategory.Caves
        ),
    )
}