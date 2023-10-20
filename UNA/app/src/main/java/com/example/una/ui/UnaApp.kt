package com.example.una.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.una.R
import com.example.una.data.UnaDatasource
import com.example.una.ui.theme.UnaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UnaApp() {
    Scaffold(
        topBar = {
            UnaAppBar(
                onBackButtonClick = { /*TODO*/ }
            )
        }
    ) {
        SiteList(
            sites = UnaDatasource.sites,
            modifier = Modifier.padding(it)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UnaAppBar(
onBackButtonClick: () -> Unit,
modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_title),
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        },
//        navigationIcon = if (!isShowingListPage) {
//            {
//                IconButton(onClick = onBackButtonClick) {
//                    Icon(
//                        imageVector = Icons.Filled.ArrowBack,
//                        contentDescription = stringResource(R.string.back_button)
//                    )
//                }
//            }
//        } else {
//            { Box {} }
//        },
        colors = TopAppBarDefaults.mediumTopAppBarColors (
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
    )
}

@Preview
@Composable
fun PreviewUnaApp() {
    UnaTheme {
        UnaApp()
    }
}