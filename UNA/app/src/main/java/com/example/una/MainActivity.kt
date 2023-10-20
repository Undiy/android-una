package com.example.una

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import com.example.una.ui.UnaApp
import com.example.una.ui.theme.UnaTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnaTheme {
                Surface {
                    val windowSizeClass = calculateWindowSizeClass(activity = this)
                    UnaApp(
                        windowWidth = windowSizeClass.widthSizeClass
                    )
                }
            }
        }
    }
}