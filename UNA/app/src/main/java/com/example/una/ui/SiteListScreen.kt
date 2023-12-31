package com.example.una.ui

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.una.data.UnaDatasource
import com.example.una.data.UnaSite
import com.example.una.ui.theme.UnaTheme

@Composable
fun SiteList(
    sites: List<UnaSite>,
    selectedSite : UnaSite?,
    onSiteClick: (UnaSite) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(sites) { site ->
            SiteListItem(
                site = site,
                isSelected = selectedSite?.equals(site) ?: false,
                onClick = { onSiteClick(site) }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SiteListItem(
    site: UnaSite,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val color by animateColorAsState(
        targetValue = if (isSelected) {
            MaterialTheme.colorScheme.primaryContainer
        } else {
            MaterialTheme.colorScheme.secondaryContainer
        },
        label = "selected_color"
    )

   Card(
       modifier = modifier,
       onClick = onClick,
       colors = CardDefaults.cardColors(
            containerColor = color
       )
   ) {
       Row(
            modifier = Modifier
                .padding(8.dp)
       ) {
           Image(
               painter = painterResource(id = site.image),
               contentDescription = null,
               contentScale = ContentScale.Crop,
               modifier = Modifier
                   .size(72.dp)
                   .clip(RoundedCornerShape(50))
           )
           Spacer(modifier = Modifier.width(16.dp))
           Text(
                text = stringResource(id = site.title),
               modifier = Modifier
                   .weight(1f)
           )
       }
   }
}

@Preview(showBackground = true)
@Composable
fun SiteListItemPreview() {
    UnaTheme {
        SiteListItem(
            site = UnaDatasource.sites.first(),
            isSelected = false,
            onClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SiteListPreview() {
    UnaTheme {
        SiteList(
            sites = UnaDatasource.sites,
            selectedSite = UnaDatasource.sites[1],
            onSiteClick = {}
        )
    }
}
