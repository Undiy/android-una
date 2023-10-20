package com.example.una.ui

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(sites) {
            SiteListItem(site = it)
        }
    }
}

@Composable
fun SiteListItem(
    site: UnaSite,
    modifier: Modifier = Modifier
) {
   Card(
       modifier = modifier
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
        SiteListItem(site = UnaDatasource.sites.first())
    }
}

@Preview(showBackground = true)
@Composable
fun SiteListPreview() {
    UnaTheme {
        SiteList(sites = UnaDatasource.sites)
    }
}
