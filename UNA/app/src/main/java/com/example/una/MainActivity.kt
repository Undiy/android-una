package com.example.una

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import com.example.una.ui.UnaApp
import com.example.una.ui.theme.UnaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnaTheme {
                // A surface container using the 'background' color from the theme
                Surface {
                    UnaApp()
                }
            }
        }
    }
}