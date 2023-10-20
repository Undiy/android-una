package com.example.una.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.una.R
import com.example.una.ui.theme.UnaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UnaApp(
    windowWidth: WindowWidthSizeClass
) {

    val viewModel: UnaViewModel = viewModel()
    val unaUiState = viewModel.uiState.collectAsState().value

    Scaffold(
        topBar = {
            UnaAppBar(
                onBackButtonClick = viewModel::resetSelectedSite,
                showNavigationIcon = windowWidth == WindowWidthSizeClass.Compact
                        && unaUiState.currentSelectedSite != null
            )
        }
    ) {
        when (windowWidth) {
            WindowWidthSizeClass.Compact -> UnaCompactScreen(
                uiState = unaUiState,
                viewModel = viewModel,
                modifier = Modifier.padding(it)
            )
            WindowWidthSizeClass.Medium -> UnaExpandedScreen(
                uiState = unaUiState,
                viewModel = viewModel,
                modifier = Modifier.padding(it)
            )
            WindowWidthSizeClass.Expanded -> UnaExpandedScreen(
                uiState = unaUiState,
                viewModel = viewModel,
                modifier = Modifier.padding(it)
            )
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UnaAppBar(
    onBackButtonClick: () -> Unit,
    showNavigationIcon : Boolean,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_title),
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        },
        navigationIcon = if (showNavigationIcon) {
            {
                IconButton(onClick = onBackButtonClick) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        } else {
            { Box {} }
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors (
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
    )
}

@Composable
fun UnaCompactScreen(
    uiState: UnaUiState,
    viewModel: UnaViewModel,
    modifier: Modifier = Modifier
) {
    if (uiState.currentSelectedSite == null) {
        SiteList(
            sites = uiState.sites,
            onSiteClick = viewModel::updateSelectedSite,
            modifier
        )
    } else {
        SiteDetails(
            site = uiState.currentSelectedSite,
            onBack = viewModel::resetSelectedSite,
            modifier
        )
    }
}

@Composable
fun UnaExpandedScreen(
    uiState: UnaUiState,
    viewModel: UnaViewModel,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
    ) {
        SiteList(
            sites = uiState.sites,
            onSiteClick = viewModel::updateSelectedSite,
            modifier = Modifier.weight(2f)
        )
        if (uiState.currentSelectedSite == null) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(3f)
            ) {
                Text(stringResource(R.string.pick_a_site_to_view_details))
            }
        } else {
            SiteDetails(
                site = uiState.currentSelectedSite,
                onBack = viewModel::resetSelectedSite,
                modifier = Modifier.weight(3f)
            )
        }
    }

}

@Preview
@Composable
fun PreviewUnaApp() {
    UnaTheme {
        UnaApp(windowWidth = WindowWidthSizeClass.Compact)
    }
}

@Preview(widthDp = 1000)
@Composable
fun PreviewUnaAppExpanded() {
    UnaTheme {
        UnaApp(windowWidth = WindowWidthSizeClass.Expanded)
    }
}