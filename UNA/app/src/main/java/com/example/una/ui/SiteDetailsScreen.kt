package com.example.una.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.una.data.UnaDatasource
import com.example.una.data.UnaSite
import com.example.una.ui.theme.UnaTheme

@Composable
fun SiteDetails(
    site: UnaSite,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler(onBack = onBack)
    Column(
        modifier = modifier
            .background(color = MaterialTheme.colorScheme.secondaryContainer)
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = painterResource(id = site.image),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            alignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(160.dp, 240.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxHeight()
        ) {
            Text(
                text = stringResource(id = site.title),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(id = site.info),
                textAlign = TextAlign.Justify,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SiteDetailsPreview() {
    UnaTheme {
        SiteDetails(
            site = UnaDatasource.sites[5],
            onBack = {}
        )
    }
}