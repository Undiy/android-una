package com.example.una.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.una.R
import com.example.una.data.UnaCategory
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
                        && unaUiState.selectedSite != null
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
                text = stringResource(id = R.string.app_title)
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
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
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
    if (uiState.selectedSite == null) {
        Column(modifier) {
            SiteList(
                sites = uiState.sites,
                selectedSite = null,
                onSiteClick = viewModel::updateSelectedSite,
                modifier = Modifier.weight(1f)
            )
            UnaBottomNavBar(
                selectedCategory = uiState.selectedCategory,
                onClick = viewModel::updateSelectedCategory
            )

        }
    } else {
        SiteDetails(
            site = uiState.selectedSite,
            onBack = viewModel::resetSelectedSite,
            modifier = modifier
        )
    }
}

@Composable
fun UnaBottomNavBar(
    selectedCategory: UnaCategory,
    onClick: (UnaCategory) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar(modifier = modifier) {
        for (category in UnaCategory.values()) {
            NavigationBarItem(
                selected = category == selectedCategory,
                onClick = { onClick(category) },
                icon = {
                       Icon(
                           imageVector = ImageVector.vectorResource(id = category.icon),
                           contentDescription = stringResource(id = category.title),
                           modifier = Modifier.size(24.dp)
                       )
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UnaExpandedScreen(
    uiState: UnaUiState,
    viewModel: UnaViewModel,
    modifier: Modifier = Modifier
) {
    PermanentNavigationDrawer(
        drawerContent = {
            PermanentDrawerSheet(modifier = Modifier.width(240.dp)) {
                UnaNavigationDrawerContent(
                    selectedCategory = uiState.selectedCategory,
                    onClick = viewModel::updateSelectedCategory,
                    modifier = Modifier
                        .fillMaxHeight()
                      .padding(16.dp)
                )
            }
        },
        modifier = modifier
    ) {
        Row {
            SiteList(
                sites = uiState.sites,
                selectedSite = uiState.selectedSite,
                onSiteClick = viewModel::updateSelectedSite,
                modifier = Modifier.weight(2f)
            )
            if (uiState.selectedSite == null) {
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
                    site = uiState.selectedSite,
                    onBack = viewModel::resetSelectedSite,
                    modifier = Modifier.weight(3f)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UnaNavigationDrawerContent(
    selectedCategory: UnaCategory,
    onClick: (UnaCategory) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        for (category in UnaCategory.values()) {
            NavigationDrawerItem(
                selected = selectedCategory == category,
                label = {
                    Text(
                        text = stringResource(category.title)
                    )
                },
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(category.icon),
                        contentDescription = stringResource(category.title),
                        modifier = Modifier.size(32.dp)
                    )
                },
                colors = NavigationDrawerItemDefaults.colors(
                    unselectedContainerColor = Color.Transparent
                ),
                onClick = { onClick(category) }
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
